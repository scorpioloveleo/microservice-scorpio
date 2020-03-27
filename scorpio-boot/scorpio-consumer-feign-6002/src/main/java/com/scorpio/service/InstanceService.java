package com.scorpio.service;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.scorpio.entity.Instance;
import com.scorpio.rpcclient.HystrixWithFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InstanceService {
    private static String DEFAULT_SERVICE_ID = "application";
    private static String DEFAULT_HOST = "localhost";
    private static int DEFAULT_PORT = 8080;
    private static Logger logger = LoggerFactory.getLogger(InstanceService.class) ;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HystrixWithFeignClient hystrixWithFeignClient;

    /**
     * 直接调用不经过feign,配置服务降级处理方法
     */
    //@HystrixCommand(fallbackMethod = "instanceInfoGetFail") 使用此注解，需要依赖原生的hystix包。
    public String getInstanceByServiceIdWithRestTemplate(String name) {
        String body = restTemplate.getForEntity("http://scorpio-provider-5001/error/{name}", String.class, name).getBody();
        return body;
    }

    private String instanceInfoGetFail(String serviceId) {
        logger.info("Can not get Instance by serviceId {}", serviceId);
        return "服务不可用，请稍后尝试！";
    }


    /**
     * 经过feign，不依赖原生的hystirx包
     *
     */
    public String getInstanceByServiceIdWithRestTemplateWithFeign(String name) {
       return hystrixWithFeignClient.getData2(name);
    }
}
