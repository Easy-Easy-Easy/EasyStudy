package com.easy.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FanoutListener
 * @Description TODO
 * @Author zheng
 * @Date 2021/7/21 10:03
 * @Version 1.0
 **/
@Component
public class FanoutListener {
    @RabbitListener(queues = "fanoutQueue")
    public void process(String msg) {
        System.out.println("第一个监听器监听的数据：" + msg);
    }
}
