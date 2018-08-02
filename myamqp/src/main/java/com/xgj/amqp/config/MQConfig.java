package com.xgj.amqp.config;

import com.xgj.amqp.messageconverter.RabbitMQFastJsonConverter;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: MQConfig
 * @package: com.xgj.amqp.config
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/10 10:58
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Configuration
public class MQConfig {
    /**
     * 注册接收消息的容器
     * @param connectionFactory
     * @return
     */
    @Bean(name = "rabbitListenerContainerFactory")
//    @ConditionalOnMissingBean(name={"rabbitListenerContainerFactory"})
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new RabbitMQFastJsonConverter());
        factory.setDefaultRequeueRejected(false);
        return factory;
    }


    @Primary
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new RabbitMQFastJsonConverter());// 序列化
        return template;
    }
}
