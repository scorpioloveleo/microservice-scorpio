package com.scorpio.controller;

import com.scorpio.entity.HouseInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")



public class StudyRestTemplateController {

    @GetMapping("data")
    public HouseInfo getData(@RequestParam("name") String name){
        return new HouseInfo(1L, "上海", "虹口", "东林小区");
    }

    @GetMapping("data/{name}")
    public String getData2(@PathVariable("name") String name){
        return name;
    }

    @PostMapping("save")
    public String getData3(HouseInfo houseInfo){
        System.out.println("save ："+houseInfo.toString());
        return "OK";
    }
}
