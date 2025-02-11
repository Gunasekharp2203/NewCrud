package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Department;
import com.example.demo.ServiceImpl.DepartmentServiceImpl;

@RestController
public class DepartmentController {
	
	@Autowired
	public DepartmentServiceImpl deptImpl;
	
	@GetMapping("/depts/all")
	public List<Department>findAllDeps(){
		return deptImpl.getAllDept();
		}
	
	@GetMapping("/dept/{id}")
	public Department getDeptById(@PathVariable int id) {
		return deptImpl.getDeptById(id);
	}

	

}
