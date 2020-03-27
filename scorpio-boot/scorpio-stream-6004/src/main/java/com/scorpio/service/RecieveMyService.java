package com.scorpio.service;

import com.scorpio.sink.MySink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MySink.class)
public class RecieveMyService {

    @StreamListener(MySink.INPUT)
    public void recieve(String payload){
        System.out.println(payload);
    }
}
