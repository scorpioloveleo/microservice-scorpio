package com.scorpio.rpcclient;

import com.scorpio.entity.HouseInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HystrixWithFeignClientFallBack implements HystrixWithFeignClient {

    @Override
    public String getData2(@PathVariable("name") String name){
        return "服务不可用,请稍后重试";
    }

}
