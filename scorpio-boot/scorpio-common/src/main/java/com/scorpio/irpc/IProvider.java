package com.scorpio.irpc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IProvider {

    @RequestMapping(value = "/token/generate",method = RequestMethod.POST)
    String generateToken(String name);
}
