package com.scorpio;

import com.scorpio.filter.EnableLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NettyApplication4000 {
    public static void main(String[] args) {
        //自定义启动参数,此处为自定义随机端口
        //new StartCommand(args);
        SpringApplication.run(NettyApplication4000.class);


    }

    @RequestMapping("/start")
    public String firtOne(){
        return "OK";
    }
}
