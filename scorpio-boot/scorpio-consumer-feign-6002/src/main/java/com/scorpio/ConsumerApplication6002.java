package com.scorpio;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.scorpio")
//@EnableCircuitBreaker //开启hystirx，openfeign自带的hystrix好像不用此注解，在配置里面开启就可以使用了
public class ConsumerApplication6002 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication6002.class);
    }
}
