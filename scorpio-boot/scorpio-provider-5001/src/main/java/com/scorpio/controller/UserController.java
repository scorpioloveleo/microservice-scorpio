package com.scorpio.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("login")
    public String userLogin(){
        //获取token
        return "";
    }

}
