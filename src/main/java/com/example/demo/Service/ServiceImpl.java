package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmpRepo;

public interface ServiceImpl {
	public List<Employee> getAllemp();
	
	
	public List<Employee> getByFirstName(String fname);
	
	public Employee getByLastName(@RequestParam String lname);
	
	public Employee addEmployee(Employee employee);
	
	//public Employee updateFirstName(int id,String fn);


	public Employee updateFirstName(int id, String firstName);
	
	public Employee updateLastName(int id,String lastName);
	
	public void deleteById(int id);
	

	

}

@Service
class Serviceemp implements ServiceImpl{
	
	
	@Autowired
	public EmpRepo emps;

	@Override
	public List<Employee> getAllemp() {
		// TODO Auto-generated method stub
		return emps.findAll();
	}

	

	@Override
	public List<Employee> getByFirstName(String fname) {
		return emps.findByfirstName(fname);
		// TODO Auto-generated method stub
		//return em1;
	}



	@Override
	public Employee getByLastName(String lname) {
		// TODO Auto-generated method stub
		return emps.findEmployeeByLastName(lname);
	}



	



	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return emps.save(employee);
	}



	@Override
	public Employee updateFirstName(int id,String firstName) {
		Employee employee=emps.findById(id).orElse(null);
		if(employee!=null) {
			employee.setFirstName(firstName);
			return emps.save(employee);
		}else { throw new RuntimeException("Employee not found with id: " + id);}
		// TODO Auto-generated method stub
		
	}



	@Override
	public Employee updateLastName(int id, String lastName) {
		// TODO Auto-generated method stub
		Employee empl=emps.findById(id).orElse(null);
		if(empl!=null) {
			empl.setLastName(lastName);
			return emps.save(empl);
		
		}else {
			throw new RuntimeException("Employee Not found"+id);
		}
		
	}



	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		 emps.deleteById(id);
	
	}
}