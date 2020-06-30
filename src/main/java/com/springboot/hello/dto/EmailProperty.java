package com.springboot.hello.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class EmailProperty implements Serializable {
    /**
     * name
     */
    @Value("${email.name}")
    public String name;

    /**
     * password
     */
    @Value("${email.password}")
    public String password;
}
