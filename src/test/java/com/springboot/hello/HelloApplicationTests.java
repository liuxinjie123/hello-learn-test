package com.springboot.hello;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		System.out.println(" --- test001 --- ");
		mvc.perform(MockMvcRequestBuilders.get("/hello/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		String content = content().toString();
        System.out.println("content: " + content.toString());
	}



}
