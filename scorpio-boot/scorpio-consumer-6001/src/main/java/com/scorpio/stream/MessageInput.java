package com.scorpio.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageInput {

    @Output("output")
    MessageChannel output();
}
