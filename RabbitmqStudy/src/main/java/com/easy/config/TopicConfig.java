package com.easy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName TopicConfig
 * @Description TODO
 * @Author zheng
 * @Date 2021/7/20 19:43
 * @Version 1.0
 **/
@Configuration
public class TopicConfig {
    @Bean
    public Queue temperatureTopicQueue() {
        return new Queue("temperature");
    }

    @Bean
    public Queue windDirectionTopicQueue() {
        return new Queue("windDirection");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindTemperature() {
        return BindingBuilder.bind(temperatureTopicQueue()).to(topicExchange()).with("#.temperature");
    }

    @Bean
    public Binding bindWindDirection() {
        return BindingBuilder.bind(windDirectionTopicQueue()).to(topicExchange()).with("#.windDirection");
    }
}
