package com.example.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.components.DataBaseDriver;
import com.example.demo.config.ApplicationConfiguration;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.UserService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//mention where the configuration has to be picked from
		AnnotationConfigApplicationContext appcontext= new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		appcontext.scan("com.example.demo");
		DataBaseDriver oracledriver=appcontext.getBean("oracleDriver",DataBaseDriver.class);
		DataBaseDriver mysqldriver=appcontext.getBean("mysqlDriver",DataBaseDriver.class);
		// do some repository data access work
		
		EmployeeRepository emp_repo=appcontext.getBean(EmployeeRepository.class);
		//store values
		emp_repo.store(new Employee(1, "Harry", "Web Dev"));
		emp_repo.store(new Employee(2, "Ron", "Java Dev"));
		emp_repo.store(new Employee(1, "Hermione", "Full Stack Dev"));
		//search values
		System.out.println(emp_repo.search("Hermione"));
		//retrieve values
		System.out.println(emp_repo.retrieve(2));
		System.out.println(emp_repo.retrieve(1));
		//delete values
		System.out.println(emp_repo.delete(2));
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
