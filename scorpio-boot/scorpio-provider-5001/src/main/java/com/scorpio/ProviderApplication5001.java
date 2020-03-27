package com.scorpio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class ProviderApplication5001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication5001.class);
    }
}
