package com.example.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.components.DataBaseDriver;
import com.example.demo.config.ApplicationConfiguration;
import com.example.demo.service.UserService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//mention where the configuration has to be picked from
		AnnotationConfigApplicationContext appcontext= new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		DataBaseDriver oracledriver=appcontext.getBean("oracleDriver",DataBaseDriver.class);
		DataBaseDriver mysqldriver=appcontext.getBean("mysqlDriver",DataBaseDriver.class);
		System.out.println("Oracle Driver information");
		System.out.println(oracledriver.getInfo());
		System.out.println("MySql Driver information");
		System.out.println(mysqldriver.getInfo());
		System.out.println("User Service information");
		UserService userService=appcontext.getBean(UserService.class);
		System.out.println(userService.getDriverInfo());
		appcontext.close();
	}

}
