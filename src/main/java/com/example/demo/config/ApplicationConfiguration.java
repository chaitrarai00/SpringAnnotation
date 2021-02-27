package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.example.demo.components.DataBaseDriver;
import com.example.demo.components.MySqlDriver;
import com.example.demo.components.OracleDriver;
import com.example.demo.service.UserService;

/*
 * The class having all configuration like defining the bean
 * and configure the spring components
 * mentioning package where scanning needs to be done
 * and setting properties to environment
 */
@Configuration
@Component("com.example.demo")
@PropertySource("classpath:oracledatabase.properties")
public class ApplicationConfiguration {
	//get environment where application is currently running
	@Autowired
	Environment environment;
	
	//define the bean
	@Bean
	DataBaseDriver oracleDriver() {
		OracleDriver oracleDriver=new OracleDriver();
		// we set values to this bean from properties file for illustration
		oracleDriver.setDatabaseurl(environment.getProperty("db.url"));
		oracleDriver.setDatabaseport(Integer.parseInt(environment.getProperty("db.port")));
		oracleDriver.setDatabasedriver(environment.getProperty("db.driver"));
		oracleDriver.setDatabaseuser(environment.getProperty("db.user"));
		oracleDriver.setDatabasepassword(environment.getProperty("db.password"));
		return oracleDriver;
	}
	@Bean
	DataBaseDriver mysqlDriver() {
		return new MySqlDriver();
	}
	
	@Bean
	UserService userservice() {
		return new UserService();
	}
}
