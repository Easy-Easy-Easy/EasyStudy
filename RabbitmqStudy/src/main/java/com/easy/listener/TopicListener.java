package com.easy.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName TopicListener
 * @Description TODO
 * @Author zheng
 * @Date 2021/7/20 20:38
 * @Version 1.0
 **/
@Component
public class TopicListener {
    @RabbitListener(queues = "temperature")
    public void temperature(String msg) {
        System.out.println("temperature" + msg);
    }

    @RabbitListener(queues = "windDirection")
    public void windDirection(String msg) {
        System.out.println("第一个监听器监听到的数据：windDirection" + msg);
    }
    @RabbitListener(queues = "windDirection")
    public void windDirection1(String msg) {
        System.out.println("第二个监听器监听到的数据：windDirection" + msg);
    }
}
