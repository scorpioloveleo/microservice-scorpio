package com.scorpio.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//此配置类不能在@ComponentScan下，否则全局都会使用该策略
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //return new RandomRule();

        return new RoundRoinb_FW();
    }
}
