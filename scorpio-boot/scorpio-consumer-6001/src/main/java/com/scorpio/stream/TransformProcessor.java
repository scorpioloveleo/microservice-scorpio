package com.scorpio.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
public class TransformProcessor {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.INPUT)
    public String hanle(){
        return "";
    }
}
