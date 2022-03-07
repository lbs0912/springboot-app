package com.lbs0912.springboot.app;

import com.lbs0912.springboot.app.service.HelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;
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

		//使用框架 API ClassPathXmlApplicationContext() 来创建应用程序的上下文。这个 API 加载 beans 的配置文件并最终基于所提供的 API，它处理创建并初始化所有的对象，即在配置文件中提到的 beans
		ApplicationContext context = new ClassPathXmlApplicationContext("BeanConfig.xml");
		getMsgFromBean(context);


	}

	private static void getMsgFromBean(ApplicationContext context){
		HelloWorld helloWorldObj = (HelloWorld) context.getBean("helloWorld");
		System.out.println(helloWorldObj.getMessage());
	}

}
