package com.scorpio.controller;

import com.scorpio.entity.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author M70CJEHA
 */
@RestController
@RequestMapping("/substitution")
public class SubstitutionOrder {

    @Autowired
    private RestTemplate restTemplate;



    //直接调用，没有经过eureka  是不是加了什么东西导致这个无法直接通过ip访问
    @GetMapping("/getConfigtest")
    public String getObjectFor1(){
        return restTemplate.getForObject("http://localhost:5001/config/who", String.class);
    }

    //经过eureka调用
    @GetMapping("/getConfig")
    public String getObjectFor(){
        return restTemplate.getForObject("http://scorpio-provider-5001/config/who", String.class);
    }

    //关于接口调用有3种实现方式，第一种，url调用，第二种: getForObject 第三种:getForEntity

    @GetMapping("/data")
    public HouseInfo getData(@RequestParam("name") String name){
        return restTemplate.getForObject("http://scorpio-provider-5001/data?name="+name, HouseInfo.class);
    }

    @GetMapping("/data/{name}")
    public String getData2(@PathVariable("name") String name){
        return restTemplate.getForObject("http://scorpio-provider-5001/data/{name}", String.class, name);
        //return restTemplate.getForObject("http://scorpio-provider-5001/data/"+name, String.class); 这个写法也可以
    }

    //第三种
    @GetMapping("/data2")
    public HouseInfo getData3(@RequestParam("name") String name){
        ResponseEntity<HouseInfo> forEntity = restTemplate.getForEntity("http://scorpio-provider-5001/data?name=" + name, HouseInfo.class);
        if(forEntity.getStatusCodeValue() == 200){
            return forEntity.getBody();
        }
        return null;
    }
    /**
     * 我们再使用post试一试
     */
    @GetMapping("/add")
    public String getData3(){
        HouseInfo houseInfo = new HouseInfo(2L, "we", "23", "ert");
        return restTemplate.postForObject("http://scorpio-provider-5001/save",  houseInfo, String.class);
    }

}
