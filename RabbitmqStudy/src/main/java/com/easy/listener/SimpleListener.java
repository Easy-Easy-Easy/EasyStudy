package com.easy.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName SimpleListener
 * @Description TODO
 * @Author zheng
 * @Date 2021/7/16 18:04
 * @Version 1.0
 **/
@Component
@RabbitListener(queues = "simpleQueue")
public class SimpleListener {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("收到的消息:" + msg);
    }
}
