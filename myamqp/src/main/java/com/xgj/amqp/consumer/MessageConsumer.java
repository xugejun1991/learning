package com.xgj.amqp.consumer;

import com.alibaba.fastjson.JSON;
import com.xgj.amqp.MyMQPlat.MQListener;
import com.xgj.amqp.MyMQPlat.MQMessage;
import com.xgj.amqp.model.User;
import java.util.logging.Logger;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: MessageConsumer
 * @package: com.xgj.amqp.consumer
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/27 14:22
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Component
public class MessageConsumer extends MQListener<MQMessage<User>> {
    Logger logger = Logger.getLogger("TestListener");

    public MessageConsumer() {
        super("X");
    }

    @RabbitListener(queues = "lili", containerFactory = "rabbitListenerContainerFactory")
    @RabbitHandler
    @Override
    public void handlerMessage(MQMessage<User> content) {
        String str = JSON.toJSONString(content);
        logger.info(str);
        System.out.println(str);
    }
}
