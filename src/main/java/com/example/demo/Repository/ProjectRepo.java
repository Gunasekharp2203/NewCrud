package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Project;

public interface ProjectRepo extends JpaRepository<Project,Integer>{

	List<Project> findAll();

}
