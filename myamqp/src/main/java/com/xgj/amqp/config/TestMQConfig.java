package com.xgj.amqp.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: WebConfigurationConfig
 * @package: cn.freemud.svc.config
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: 10buns<jiale.wang @ freemud.cn>
 * @date: 2018/5/16 23:45
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Component
public class TestMQConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private ConnectionFactory connectionFactory;

    @PostConstruct
    public void init(){
        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
        Exchange topicExchange = new TopicExchange("A");
        admin.declareExchange(topicExchange);


        Queue testQueue = new Queue("lili", true);
        admin.declareQueue(testQueue);


        admin.declareBinding(BindingBuilder.bind(testQueue)
                                            .to(topicExchange)
                                            .with("a").noargs());
    }

}
