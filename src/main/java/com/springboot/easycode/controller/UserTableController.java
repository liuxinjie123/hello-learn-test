package com.springboot.easycode.controller;

import com.springboot.easycode.entity.UserTable;
import com.springboot.easycode.service.UserTableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserTable)表控制层
 *
 * @author makejava
 * @since 2020-06-08 16:52:54
 */
@RestController
@RequestMapping("userTable")
public class UserTableController {
    /**
     * 服务对象
     */
    @Resource
    private UserTableService userTableService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserTable selectOne(Long id) {
        return this.userTableService.queryById(id);
    }

}