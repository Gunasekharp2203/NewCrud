package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.Department;

public interface DepartmentService {
	
	public List<Department>getAllDept();
	
	public Department getDeptById(int id);

}
