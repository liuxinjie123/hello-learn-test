package com.springboot.hello.controller;

import com.springboot.hello.common.Result;
import com.springboot.hello.dto.BaseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping(value = "longtostring")
    public Result longToStringTest() {
        BaseDto data = new BaseDto();
        String id = "1002002298393223002";
        data.setId(Long.valueOf(id));
        data.setName("TEST");
        data.setCreateTime(LocalDateTime.now());
        return Result.success(data);
    }
}
