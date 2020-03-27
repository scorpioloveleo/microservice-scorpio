package com.scorpio;


import com.scorpio.annotation.MyLoadBalanced;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class ConsumerApplication6001 {

    //@Bean
    //@LoadBalanced
    //@MyLoadBalanced   //此处是想替换原有的注解，但是代码有问题，没有成功，以后再研究
    /**
     * 主要的逻辑就是给 RestTemplate 拦截器，在请求之前对请求的地址进行替换，或者
     * 根据具体的负载策略选择服务地址 ，然后再去调用 ，这就是＠LoadBalanced 的原理
     */
    //public RestTemplate getRestTemplate(RestTemplateBuilder build){
    //   return build.build();
    //}

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication6001.class);
    }
}
