package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Project;
import com.example.demo.Service.ProjectService;


@RestController
public class ProjectController {
	
	@Autowired
	public ProjectService proImpl;
	
	@GetMapping("/projects/all")
	List<Project>findAllProjects(){
		return proImpl.findAllProjects();
	}
	
	

}
