package com.springboot.hello.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "server")
@PropertySource(value = "application.properties")
@Component
@Data
public class ServerProperty implements Serializable {
    private List<String> ips;
}
