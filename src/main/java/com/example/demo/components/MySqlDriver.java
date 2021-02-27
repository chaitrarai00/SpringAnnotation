package com.example.demo.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/*
 * mention where to get properties from @Propertysource
 * proeprty values are inserted to the @Value points
 */
@Component
@PropertySource("classname:mysqldatabase.properties")
public class MySqlDriver implements DataBaseDriver {
	@Value("$databaseName")
	private String databasename;
	@Value("$disableStatementPooling")
	private String disablestatementpool;
	
	@Override
	public String getInfo() {
		
		return "My SQL DataBase name "+databasename+" Disable statemnt pooling? "+disablestatementpool;
	}

}
