package com.xgj.amqp.MyMQPlat;


import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: MQService
 * @package: com.xgj.amqp
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/10 12:06
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Component
public class MQService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public MQService() {
    }

    public void  setExchange(String exchange){

        this.rabbitTemplate.setExchange(exchange);
        this.rabbitTemplate.afterPropertiesSet();
    }

    public void convertAndSend(String exchange, String routingKey, Object object) {
        this.rabbitTemplate.convertAndSend(exchange,routingKey,object);
    }

    public void convertAndSend(String routingKey, Object object) {
        this.rabbitTemplate.convertAndSend(routingKey, object);
    }


}

