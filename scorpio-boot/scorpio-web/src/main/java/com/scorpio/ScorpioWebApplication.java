package com.scorpio;

import com.scorpio.config.StartCommand;
import com.scorpio.entity.SourceRntity;
import com.scorpio.entity.TargetEntity;
import com.scorpio.filter.EnableLogFilter;
import com.scorpio.transfer.CommonTransfer;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableLogFilter
@RestController
@EnableCaching
public class ScorpioWebApplication {
    public static void main(String[] args) {
        //自定义启动参数,此处为自定义随机端口
        //new StartCommand(args);
        SpringApplication.run(ScorpioWebApplication.class);


    }

    @RequestMapping("/start")
    public String firtOne(){
        return "OK";
    }
}
