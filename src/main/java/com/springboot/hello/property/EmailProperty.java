package com.springboot.hello.property;

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
    private String name;

    /**
     * password
     */
    @Value("${email.password}")
    private String password;

    /**
     * remark
     */
    public String remark;
}
