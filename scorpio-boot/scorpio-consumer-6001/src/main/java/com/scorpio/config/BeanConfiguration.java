package com.scorpio.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
//第一次用这个注解的地方
@Configuration
public class BeanConfiguration {

    /*@Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }*/

    /**
     * 改造就是加一个注解，这个注解会构造LoadBalancerClient的实现类，并注入Spring容器中,只有這樣才能使用服务名称调用，否则只能用ip
     */
    /*@Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(RestTemplateBuilder build){
        return build.build();
    }*/

}
