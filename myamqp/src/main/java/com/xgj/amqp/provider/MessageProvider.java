package com.xgj.amqp.provider;

import com.alibaba.fastjson.JSON;
import com.xgj.amqp.MyMQPlat.*;
import com.xgj.amqp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: MessageProvider
 * @package: com.xgj.amqp.provider
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/27 14:21
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Component
public class MessageProvider {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(MessageProvider.class);
    /**
     * 消息队列模板
     */
    @Autowired
    private MQService mqService;

    public void sendMessage(User user) {
        logger.info("写入消息队列内容：{}", JSON.toJSONString(user));
//        amqpTemplate.convertAndSend("A", "a", object);
        Header header = new Header(MQAction.INSERT.getAction(),"test", "a", MessageVersion.VERSION_1);
        MQMessage<User> message = new MQMessage<>(header, user);
        mqService.convertAndSend("A", "a", message);
    }

    public void sendMessage(String id) {
        logger.info("写入消息队列内容：{}", id);
//        amqpTemplate.convertAndSend("A", "a", object);
        Header header = new Header(MQAction.INSERT.getAction(),"test", "a", MessageVersion.VERSION_1);
        MQMessage<String> message = new MQMessage<>(header, id);
        mqService.convertAndSend("A", "a", message);
    }

}
