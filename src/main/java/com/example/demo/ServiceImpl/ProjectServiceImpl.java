package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Project;
import com.example.demo.Repository.ProjectRepo;
import com.example.demo.Service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	public ProjectRepo proRepo;

	
	public List<Project> findAllProjects() {
		// TODO Auto-generated method stub
		return proRepo.findAll();
	}


	

	

}
