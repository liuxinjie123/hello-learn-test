package com.springboot.hello.api;

import com.springboot.hello.po.User;

public interface UserService {
    /**
     * 通过手机号查询 user
     */
    User findByMobile(String mobile);


}
