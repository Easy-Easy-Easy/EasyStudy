package com.easy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FanoutConfig
 * @Description TODO
 * @Author zheng
 * @Date 2021/7/21 9:56
 * @Version 1.0
 **/
@Configuration
public class FanoutConfig {

    @Bean
    public Queue fanoutQueue() {
        return new Queue("fanoutQueue");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindFanout() {
        return BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
    }
}
