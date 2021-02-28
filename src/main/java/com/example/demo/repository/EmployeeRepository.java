package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
@Repository
public class EmployeeRepository implements ObjectRepository<Employee> {
	//lets create a map which stores data for us
	private Map<Integer, Employee> repository;
	
	public EmployeeRepository() {
		this.repository=new HashMap<>();
		//insiialize the repo
	}
	
	@Override
	public void store(Employee t) {
		repository.put(t.getId(), t);
	}

	@Override
	public Employee retrieve(int id) {
		return repository.get(id);
	}

	@Override
	public Employee search(String name) {
		Collection<Employee> emp_list=repository.values();
		for(Employee e:emp_list) {
			if(e.getName().equalsIgnoreCase(name))
				return e;
		}
		return null;
	}

	@Override
	public Employee delete(int id) {
		Employee delete=repository.get(id);
		this.repository.remove(id);
		return delete;// the method should return the deleted employee object
	}

}
