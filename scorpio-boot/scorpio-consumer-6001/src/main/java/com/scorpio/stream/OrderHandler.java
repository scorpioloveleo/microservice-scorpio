package com.scorpio.stream;

import com.scorpio.entity.Order;
import com.scorpio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class OrderHandler {

    @Autowired
    OrderService orderService;

    @StreamListener(Sink.INPUT)
    public void handle(Order order) {
        orderService.handle(order);
    }
}
