package com.scorpio.configuration;

import feign.Logger;
import feign.Request;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    /**
     * 日志级别：
     * 通过源码可以看到日志等级有
     * •  NONE 不输出日志
     * •  BASIC 只输出请求方法的 URL和响应的状态码以及接口的执行时间
     * •  HEADERS ：将 BASIC 信息和请求头信息输出
     * •  FULL ：输出完整的请求信息
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * 可以配置自带的basic权限验证,不知道有啥用，反正接口请求正常，听说还可以自定义验证规则，没试
     */
    /*@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","password");
    }*/


    /**
     * 配置超时时间
     */
    public Request.Options options(){
        return new Request.Options(5000, 10000);
    }

    /**
     * 配置编码器和解码器
     */
    /*
    @Bean;
    public Decoder decoder(){
        return new MyDecoder();
        return new MyEncoder()
    }*/
}
