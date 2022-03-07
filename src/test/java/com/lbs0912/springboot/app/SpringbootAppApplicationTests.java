package com.lbs0912.springboot.app;

import com.lbs0912.springboot.app.service.HelloWorld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootAppApplicationTests {

	@Autowired
	private HelloWorld helloWorld;

	@Test
	void contextLoads() {
		helloWorld.getMessage();
	}

}
