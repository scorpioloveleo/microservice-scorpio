package com.scorpio.stream;

import com.scorpio.entity.ComputeOrder;
import com.scorpio.entity.FoodOrder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(Sink.class)
public class TestPojoWithAnnotatedArguments {
    @StreamListener(target = Sink.INPUT, condition = "headers['type']=='food'")
    public void receiveFoodOrder(@Payload FoodOrder foodOrder) {
        // handle the message
    }
    @StreamListener(target = Sink.INPUT, condition = "headers['type']=='compute'")
    public void receiveComputeOrder(@Payload ComputeOrder computeOrder) {
        // handle the message
    }

}
