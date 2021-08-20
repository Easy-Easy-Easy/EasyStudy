package com.easy.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName DirectListener
 * @Description TODO
 * @Author zheng
 * @Date 2021/7/20 19:37
 * @Version 1.0
 **/
@Component
@RabbitListener(queues = "directQueue")
public class DirectListener {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("收到的消息:" + msg);
    }
}
