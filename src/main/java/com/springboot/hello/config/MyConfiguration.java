package com.springboot.hello.config;

import com.springboot.hello.property.AcmeProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(value = {AcmeProperties.class})
public class MyConfiguration {

}
