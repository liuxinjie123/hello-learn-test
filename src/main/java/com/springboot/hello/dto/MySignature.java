package com.springboot.hello.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@ConfigurationProperties(prefix = "mysignature")
@PropertySource(value = "application.properties")
@Component
@Data
public class MySignature implements Serializable {
    /**
     * secret
     */
    private String secret;

    private int number;

    /**
     * big number
     */
    private long bigNumber;

    /**
     * uuid
     */
    private String uuid;

    /**
     * number less than ten
     */
    private int numberLessThanTen;

    /**
     * number in range
     */
    private int numberInRange;

}







