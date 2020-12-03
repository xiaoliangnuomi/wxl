package com.xl.servicefeignb.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SERVICE-A")
public interface ServiceAFeignClient {
    @RequestMapping("testA")
    public String TestAController();
}