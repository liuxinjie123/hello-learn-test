package com.springboot.easycode.controller;

import com.springboot.easycode.entity.OrderInfo;
import com.springboot.easycode.service.OrderInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrderInfo)表控制层
 *
 * @author makejava
 * @since 2020-06-08 17:06:32
 */
@RestController
@RequestMapping("orderInfo")
public class OrderInfoController {
    /**
     * 服务对象
     */
    @Resource
    private OrderInfoService orderInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrderInfo selectOne(Long id) {
        return this.orderInfoService.queryById(id);
    }

}