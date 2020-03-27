package com.scorpio.service;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CacheService {

    public static List<String> list = new ArrayList<>();

    @Cacheable(value = "scorpio:boot:getName", key = "#name")
    public String getName(String name){
        //list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("哈皮");
        list.add("难受");
        int i = new Random().nextInt(4);
        return  list.get(i);
    }
}
