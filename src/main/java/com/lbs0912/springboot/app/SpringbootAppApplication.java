package com.lbs0912.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 *
 * @author lbs
 * @date 2020-06-10 11:19
 */
@SpringBootApplication
public class SpringbootAppApplication {

	/**
	 * main方法
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("SpringbootAppApplication Server is running ...");
		SpringApplication.run(SpringbootAppApplication.class, args);
	}

}
