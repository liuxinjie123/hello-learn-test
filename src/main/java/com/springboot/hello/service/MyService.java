package com.springboot.hello.service;

import com.springboot.hello.dto.Server;
import com.springboot.hello.property.AcmeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyService {
    @Autowired
    private AcmeProperties acmeProperties;

    @PostConstruct
    public void openConnection() {
        Server server = new Server(this.acmeProperties.getRemoteAddress());
        System.out.println("server:" + server.toString());
    }
}
