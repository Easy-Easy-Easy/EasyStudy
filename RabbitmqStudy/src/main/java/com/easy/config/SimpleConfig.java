package com.easy.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SimpleConfig
 * @Description 广播模式
 * @Author zheng
 * @Date 2021/7/16 17:55
 * @Version 1.0
 **/
@Configuration
public class SimpleConfig {
    @Bean
    public Queue simpleQueue() {
        return new Queue("simpleQueue");
    }
}
