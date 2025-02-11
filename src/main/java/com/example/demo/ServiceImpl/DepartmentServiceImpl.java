package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Department;
import com.example.demo.Repository.DepartmentRepo;
import com.example.demo.Service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	public DepartmentRepo deptRepo;

	
	public List<Department> getAllDept() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}


	@Override
	public Department getDeptById(int id) {
		// TODO Auto-generated method stub
		return deptRepo.getDepartmentById(id);
	}


	
	

}
