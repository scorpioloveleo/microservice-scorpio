package com.scorpio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/choose")
    public Object chooseUrl(){
        ServiceInstance choose = loadBalancer.choose("scorpio-provider-5001");
        return choose;
    }
}
