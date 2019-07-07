package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@MapperScan("com.example.mapper")//将项目中对应的mapper类的路径加进来就可以了
//@ComponentScan("com.example")
public class SpringbootDemoApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);
		DispatcherServlet dispatcherServlet = (DispatcherServlet) context.getBean("dispatcherServlet");
		System.out.println("dispatcherServlet = " + dispatcherServlet);

	}
}
