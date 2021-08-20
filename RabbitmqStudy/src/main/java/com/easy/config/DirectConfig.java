package com.easy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DirectConfig
 * @Description TODO
 * @Author zheng
 * @Date 2021/7/20 18:41
 * @Version 1.0
 **/
@Configuration
public class DirectConfig {
    @Bean
    public Queue directQueue() {
        return new Queue("directQueue");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding bindDirect() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
    }
}
