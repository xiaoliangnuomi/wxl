package com.xl.servicefeigna.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAController {

    @RequestMapping("testA")
    public String TestAController(){
        return "Hello,SpringCloud for TestA";
    }
}