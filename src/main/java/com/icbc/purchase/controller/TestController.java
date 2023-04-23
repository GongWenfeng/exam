package com.icbc.purchase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//todo 测试代码，待删除
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String test() {
        return "hello world";
    }

}
