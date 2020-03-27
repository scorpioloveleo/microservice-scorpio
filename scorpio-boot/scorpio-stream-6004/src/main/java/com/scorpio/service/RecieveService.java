package com.scorpio.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/*@EnableBinding(Sink.class)*/  /**因为演示消息中转，需要把处理消息的绑定注释掉，进行中转，将消息处理发送到6006进行消费*/
public class RecieveService {

    @StreamListener(Sink.INPUT)
    public void recieve(String payload){
        System.out.println(payload);
    }
}
