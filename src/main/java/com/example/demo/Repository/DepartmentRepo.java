package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.Employees;

public interface DepartmentRepo extends JpaRepository<Department,Integer>{

	List<Department> findAll();
	
	public Department getDepartmentById(@RequestParam int id);

	Optional<Department> findByDeptName(String deptName);
	


}
