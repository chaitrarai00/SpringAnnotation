package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/*
 * Lets Assume that we have a business requirement where we use service class to get driver
 * and provide the driver information from the service class
 * in this example we place the business logic in the service class as per the convention
 * so we inject the OracleDriver Bean
 */

import com.example.demo.components.DataBaseDriver;
@Service
public class UserService {
	@Autowired
	@Qualifier("oracleDriver")
	private DataBaseDriver dataBaseDriver;// we mention which databaseDriver since it is an interface and to avoid ambiguity using Qualifier
	public String getDriverInfo() {
		return dataBaseDriver.getInfo();
	}
}
