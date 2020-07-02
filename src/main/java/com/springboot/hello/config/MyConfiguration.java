package com.springboot.hello.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.springboot.hello.property.AcmeProperties;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;

@Configuration(proxyBeanMethods = false)
//@EnableConfigurationProperties(value = {AcmeProperties.class})
public class MyConfiguration {

//    @Bean
//    public HttpMessageConverters customerConverter() {
//        HttpMessageConverter<?> additional = new FastJsonHttpMessageConverter();
//        HttpMessageConverter<?> another = new JsonbHttpMessageConverter();
//        return new HttpMessageConverters(additional, another);
//    }

}
