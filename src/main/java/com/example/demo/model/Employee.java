package com.example.demo.model;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	public Employee(int id,String name, String title) {
		this.Id=id;
		this.name=name;
		this.jobtitle=title;
	}
	private int Id;
	private String name;
	private String jobtitle;
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", jobtitle=" + jobtitle + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

}
