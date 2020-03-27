package com.scorpio;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//排除数据源,不直接使用数据库，使用基于内存的Map映射
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BatchApplication6007 {

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication6007.class);
    }
}
