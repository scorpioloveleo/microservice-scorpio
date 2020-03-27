package com.scorpio.controller;


import com.scorpio.config.EnviromentConfig;
import com.scorpio.entity.SourceRntity;
import com.scorpio.entity.TargetEntity;
import com.scorpio.service.CacheService;
import com.scorpio.transfer.CommonTransfer;
import com.scorpio.utils.CopyUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StartApp {

    @Autowired
    private EnviromentConfig enviromentConfig;

    @Autowired
    private Environment environment;

    @Autowired
    private CacheService cacheService;

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name)
    {
        return "helleo  -468465654654-  ! " + name+ " the   best  author is "+environment.getProperty("server.port")
                 +" 作者是:"+enviromentConfig.getName();
    }

    @Test
    public void testOne()
    {
        /*List<SourceRntity> lists = new ArrayList<>(10000000);
        for (int i = 0; i < 10000000; i++) {
            SourceRntity sourceRntity = new SourceRntity();
            lists.add(sourceRntity);
        }
        long startTime = System.currentTimeMillis();
        List<TargetEntity> targetEntities = CommonTransfer.INSTANCE.s2TTransfer(lists);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println((endTime-startTime)/1000);
        System.gc();*/
    }

    @Test
    public void testTwo()
    {
        List<SourceRntity> lists = new ArrayList<>(10000000);
        for (int i = 0; i < 10000000; i++) {
            SourceRntity sourceRntity = new SourceRntity();
            lists.add(sourceRntity);
        }
        long startTime = System.currentTimeMillis();
        List<TargetEntity> targetEntities = CopyUtils.copyList(lists, TargetEntity.class);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println((endTime-startTime)/1000);
        System.gc();
    }

    @RequestMapping("/test02")
    public void test03(){
        List<SourceRntity> lists = new ArrayList<>();
        SourceRntity sourceRntity = new SourceRntity();
        lists.add(sourceRntity);
        List<TargetEntity> targetEntities = CopyUtils.copyList(lists, TargetEntity.class);
        targetEntities.get(0).setName1("nimenhao");
        System.out.println(sourceRntity.getName1());
    }

    @RequestMapping("/testCache")
    public String testCache(){
        String name = cacheService.getName("Lina");
        return name;
    }

    @GetMapping("shunxu")
    public String testShunxu() throws ApplicationException{
        System.out.println("======================Controller-----------------------");
        return "OK";
    }

}
