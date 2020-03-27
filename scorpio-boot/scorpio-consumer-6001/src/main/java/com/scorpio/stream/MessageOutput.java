package com.scorpio.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageOutput {

    @Input("input")
    SubscribableChannel input();

}
