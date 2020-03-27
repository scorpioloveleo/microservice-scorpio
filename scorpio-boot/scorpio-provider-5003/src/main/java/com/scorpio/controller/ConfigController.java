package com.scorpio.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @RequestMapping("/who")
    public String whoAreYou(){
        return "i am provider5003";
    }
}
