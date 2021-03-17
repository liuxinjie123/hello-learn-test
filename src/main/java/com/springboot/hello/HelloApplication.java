package com.springboot.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

@EnableAsync
@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(HelloApplication.class);
		application.setWebApplicationType(WebApplicationType.REACTIVE);
		application.run(args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(" --- beanname: " + beanName);
			}

		};
	}
}
