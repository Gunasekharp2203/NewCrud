package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entities.Employees;

public interface EmployeeRepo extends JpaRepository<Employees,Integer> {
	
	public List<Employees>findEmployeeById(@RequestParam int id);
}
