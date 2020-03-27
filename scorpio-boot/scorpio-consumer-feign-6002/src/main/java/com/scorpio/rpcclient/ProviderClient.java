package com.scorpio.rpcclient;

import com.scorpio.entity.HouseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 可以选择不加@Component, 不过编译器会出现错误警告.因为FeignService是动态注入的,会出现FeignService无法找到的警告.
// 加了@Component,向spring声明下我有一个FeignService的bean
//以上注释来自网络
//@Component
@FeignClient(name = "scorpio-provider-5001" , path = "/feign")
public interface ProviderClient {

    @GetMapping(value = "/data")
    HouseInfo getData(@RequestParam(value = "name") String name);

    @GetMapping("data/{name}")
    String getData2(@PathVariable("name") String name);

    @PostMapping("save")
    HouseInfo getData3(HouseInfo houseInfo);
}
