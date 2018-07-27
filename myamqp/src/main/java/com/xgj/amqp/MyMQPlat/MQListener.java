package com.xgj.amqp.MyMQPlat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: AbstractMQListener
 * @package: com.xgj.amqp
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/27 14:08
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public abstract class MQListener<T> {
    private static final String ACTION_ERROR = "error";
    private static final String ERROR_FROM = "mq_consummer";
    protected Logger logger = LoggerFactory.getLogger(getClass());


    @Value("${rabbitmq.retry-times:1}")
    protected int retryTimes;

    @Autowired
    private MQService mqService;

    private String catelogry;

    public MQListener(String catelogry) {
        this.catelogry = catelogry;
    }

    /**
     * 该方法被覆盖时，必须要 添加RabbitListener 与RabbitHandler 才能正常接收数据
     *
     * @param content
     * @RabbitListener(queues = MQService.PAY_QUEUE, containerFactory = "rabbitListenerContainerFactory")
     * @RabbitHandler
     */
    public abstract void handlerMessage(@Payload T content);

    public void sendErrorMessage(MQMessage msg, String errorQueue, String exchange) {
        Header header = new Header("error", "mq_consummer", errorQueue, this.catelogry);
        msg.setHeader(header);
        this.mqService.convertAndSend(exchange, errorQueue, msg);
    }
}
