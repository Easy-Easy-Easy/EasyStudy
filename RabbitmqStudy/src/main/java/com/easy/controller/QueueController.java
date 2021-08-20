package com.easy.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName QueueController
 * @Description TODO
 * @Author zheng
 * @Date 2021/7/16 18:00
 * @Version 1.0
 **/
@RequestMapping("queue")
@RestController
public class QueueController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("simple")
    public void simpleQueue() {
        rabbitTemplate.convertAndSend("simpleQueue", "简单消息" + new Date());
    }

    @RequestMapping("direct")
    public void direct() {
        rabbitTemplate.convertAndSend("directExchange", "direct", "direct" + new Date());
        rabbitTemplate.convertAndSend("directExchange", "direct1", "direct" + new Date());
    }

    @RequestMapping("topic")
    public void topic() {
        rabbitTemplate.convertAndSend("topicExchange", "beijing.temperature", "北京的温度是36");
        rabbitTemplate.convertAndSend("topicExchange", "henan.temperature", "河南的温度是38");
        rabbitTemplate.convertAndSend("topicExchange", "beijing.windDirection", "北京的风向是东南风");
        rabbitTemplate.convertAndSend("topicExchange", "henan.windDirection", "河南的风向是西北风");
    }

    @RequestMapping("fanout")
    public void fanout() {
        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend("fanoutExchange", "", "广播模式数据" + i);
        }
    }

}
