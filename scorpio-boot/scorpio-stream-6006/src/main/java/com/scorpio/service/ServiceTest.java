package com.scorpio.service;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ServiceTest {

    public static void main(String[] args) {
        long timestamp = LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(timestamp);
    }
}
