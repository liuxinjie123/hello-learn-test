package com.springboot.hello.property;

import com.alibaba.fastjson.JSON;
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
    public String secret;

    public int number;

    /**
     * big number
     */
    public long bigNumber;

    /**
     * uuid
     */
    public String uuid;

    /**
     * number less than ten
     */
    public int numberLessThanTen;

    /**
     * number in range
     */
    public int numberInRange;


}







