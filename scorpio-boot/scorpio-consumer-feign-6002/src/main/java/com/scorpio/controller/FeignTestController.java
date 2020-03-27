package com.scorpio.controller;

import com.scorpio.entity.HouseInfo;
import com.scorpio.rpcclient.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")
public class FeignTestController {

    /**
     * 不使用ribbon + restTemplate的方式，使用feign来调用
     */
    @Autowired
    private ProviderClient providerClient;

    @GetMapping("/data")
    public HouseInfo getDataByFeign(@RequestParam("name") String name){
        return providerClient.getData(name);
    }

    @GetMapping("/data/{name}")
    public String getDataByFeign2(@PathVariable("name") String name){
        return providerClient.getData2(name);
    }

    @GetMapping("/data2")
    public HouseInfo getDataByFeign3(@RequestParam("name") String name){
        return providerClient.getData3(new HouseInfo(36L, "123","123", "456"));
    }

}
