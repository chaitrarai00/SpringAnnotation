package com.example.demo.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("oracledatabase.properties")
public class OracleDriver implements DataBaseDriver{
	public String getDatabaseurl() {
		return databaseurl;
	}
	public void setDatabaseurl(String databaseurl) {
		this.databaseurl = databaseurl;
	}
	public int getDatabaseport() {
		return databaseport;
	}
	public void setDatabaseport(int databaseport) {
		this.databaseport = databaseport;
	}
	public String getDatabaseuser() {
		return databaseuser;
	}
	public void setDatabaseuser(String databaseuser) {
		this.databaseuser = databaseuser;
	}
	public String getDatabasepassword() {
		return databasepassword;
	}
	public void setDatabasepassword(String databasepassword) {
		this.databasepassword = databasepassword;
	}
	public String getDatabasedriver() {
		return databasedriver;
	}
	public void setDatabasedriver(String databasedriver) {
		this.databasedriver = databasedriver;
	}
	@Value("$db.url")
	private String databaseurl;
	@Value("$db.port")
	private int databaseport;
	@Value("$db.user")
	private String databaseuser;
	@Value("$db.password")
	private String databasepassword;
	@Value("$db.driver")
	private String databasedriver;
	
	public String getInfo() {
        return "[ Driver: Oracle" +
                ", url: " + databaseurl +
                ", port; " + databaseport +
                ", user: " + databaseuser +
                ", password: " + databasepassword  +
                ", driver: " + databasedriver +
                " ] ";
    }
}
