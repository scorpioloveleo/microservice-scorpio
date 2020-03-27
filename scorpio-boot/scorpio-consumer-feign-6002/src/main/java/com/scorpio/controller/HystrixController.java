package com.scorpio.controller;

import com.scorpio.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    /**
     * hystrix还有请求合并的功能，暂时没用到，没有尝试
     */

    @Autowired
    private InstanceService instanceService;

    @RequestMapping("/getData")
    public String getData() {
        return instanceService.getInstanceByServiceIdWithRestTemplate("james");
    }

    @RequestMapping("/getData2")
    public String getData2() {
        return instanceService.getInstanceByServiceIdWithRestTemplateWithFeign("james");
    }


}
