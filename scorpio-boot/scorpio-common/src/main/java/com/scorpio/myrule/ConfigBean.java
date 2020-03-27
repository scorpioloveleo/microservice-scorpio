package com.scorpio.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {    //@Configuration+ConfigBean  = application.xml

    /*@Bean
    @LoadBalanced  //开启ribbon客户端的负载均衡 未显示声明则用轮询策略
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }*/

    /**
     * 显示声明ribbon的负载均衡策略,否则是
     * @return
     */
    @Bean
    public IRule myRule(){
         //return new RandomRule();   //显示声明ribbon的负载均衡策略  此处为随机策略

        //return new RoundRobinRule();   //此处为默认的 轮询策略

        //该策略在正常的时候就是轮询策略，当其中一台微服务宕机之后，
        // 在访问一定次数（内部策略）后会自动剔除该策略
        //return new RetryRule();    /**此策略未测试成功**/
        return new RoundRoinb_FW();  /**将自定义的策略显示声明**/
    }
}
