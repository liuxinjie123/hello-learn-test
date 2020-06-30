package com.springboot.hello.controller;

import com.springboot.hello.common.Result;
import com.springboot.hello.dto.EmailProperty;
import com.springboot.hello.dto.MySignature;
import com.springboot.hello.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/hello")
@RestController
public class HelloController {
    @Autowired
    private MySignature mySignature;
    @Autowired
    private EmailProperty emailProperty;

    @GetMapping(value = "/hello")
    public Result helloSpringBoot() {
        String str = "Hello SpringBoot";
        return Result.success2(str);
    }

    /**
     * 测试读取配置文件
     *
     * @ConfigurationProperties(prefix = "mysignature")
     * @PropertySource(value = "application.properties")
     */
    @GetMapping(value = "/property/1")
    public Result readPropertyConfig() {
        return Result.success2(ReflectionUtil.toJSON(mySignature));
    }

    /**
     * 测试读取配置文件 - @Value("${email.name}")
     */
    @GetMapping(value = "/property/2")
    public Result readPropertyConfig2() {
        return Result.success2(ReflectionUtil.toJSON(emailProperty));
    }
}
