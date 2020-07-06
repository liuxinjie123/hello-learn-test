package com.springboot.hello.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.hello.common.Result;
import com.springboot.hello.exception.BusinessException;
import com.springboot.hello.property.*;
import com.springboot.hello.service.MyService;
import com.springboot.hello.util.ReflectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping(value = "/hello")
@RestController
@Slf4j
public class HelloController {
    @Autowired
    private MySignature mySignature;
    @Autowired
    private EmailProperty emailProperty;
    @Autowired
    private ServerProperty serverProperty;
    @Autowired
    private MyService myService;
    @Autowired
    private AcmeProperties acmeProperties;
    @Autowired
    private AppSystemProperties appSystemProperties;
    @Autowired
    private AppIoProperties appIoProperties;

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
        return Result.success2(emailProperty);
    }

    /**
     * 测试读取配置文件，读 list
     */
    @GetMapping(value = "/property/3")
    public Result readPropertyList() {
        return Result.success2(ReflectionUtil.toJSON(serverProperty));
    }

    /**
     * 测试读取 yml 配置文件
     */
    @GetMapping(value = "/property/yml")
    public Result readYmlProperty() {
        myService.openConnection();
        return Result.success();
    }

    /**
     * 测试读取 yml 配置文件
     */
    @GetMapping(value = "/property/yml2")
    public Result readYmlProperty2() {
        for (String key : acmeProperties.getMap().keySet()) {
            System.out.println(key + " : " + acmeProperties.getMap().get(key));
        }
        return Result.success2(JSON.toJSON(acmeProperties));
    }

    /**
     * 测试读取配置文件 app.system
     */
    @GetMapping(value = "/property/app/system")
    public Result readAppSystemProperty() {
        return Result.success2(JSON.toJSONString(appSystemProperties));
    }

    /**
     * 测试读取配置文件 app.io
     */
    @GetMapping(value = "/property/app/io")
    public Result readAppIoProperty() {
        return Result.success2(JSON.toJSONString(appIoProperties));
    }

    /**
     * 测试 business exception
     */
    @GetMapping(value = "/exception/resolver")
    public Result testExceptionResolver() {
        Random random = new Random(20);
        int num = random.nextInt(20);
        for (int i=0; i<30; i++) {
            log.info("num: {}.", num);
        }
        if (num < 10) {
            throw new BusinessException("the random num is :" + num);
        }
        return Result.success(String.valueOf(num));
    }

}
