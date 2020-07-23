package com.springboot.hello.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.springboot.hello.property.AcmeProperties;
import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.codec.CodecCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.concurrent.TimeUnit;

@Configuration(proxyBeanMethods = false)
//@EnableWebFlux
//@EnableConfigurationProperties(value = {AcmeProperties.class})
public class MyConfiguration {

//    @Bean
//    public HttpMessageConverters customerConverter() {
//        HttpMessageConverter<?> additional = new FastJsonHttpMessageConverter();
//        HttpMessageConverter<?> another = new JsonbHttpMessageConverter();
//        return new HttpMessageConverters(additional, another);
//    }

    @Bean
    public CodecCustomizer myCodecCustomizer() {
        return codeConfigure -> {

        };
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(8002);
        return factory;
    }

}
