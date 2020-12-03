package com.xl.servicefeignb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiaol
 * @Date 2020/12/2 15:59
 * @Version 1.0
 */
@RestController
public class TestB1Controller {
    @Autowired
    private ServiceAFeignClient serviceAFeignClient;
    @GetMapping("/call1")
    public String get(){
        String result = serviceAFeignClient.TestAController();
        return "b1 to a 访问结果 ---" + result;
    }
}
