package com.springboot.hello.service;

import com.springboot.hello.api.UserService;
import com.springboot.hello.po.User;
import com.springboot.hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByMobile(String mobile) {
        return userRepository.findByMobile(mobile);
    }
}
