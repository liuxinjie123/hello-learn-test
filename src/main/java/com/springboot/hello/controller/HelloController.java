package com.springboot.hello.controller;

import com.springboot.hello.connon.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/hello")
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public Result HelloSpringBoot() {
        String str = "Hello SpringBoot";
        return Result.success2(str);
    }


}
