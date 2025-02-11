package com.example.demo.Entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_project")
public class Employee_Project {
	
	@EmbeddedId
    private EmployeeProjectId id;
	
	@ManyToOne
	@MapsId("employeeId")
	@JoinColumn(name="employee_id")
	private Employees employee;
	
	@ManyToOne
	@MapsId("projectId")
	@JoinColumn(name="project_id")
	private Project project;
	
	

	public Employee_Project() {
		super();
	}

	public Employee_Project(Employees employee, Project project) {
		super();
		this.employee = employee;
		this.project = project;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Employee_Project [employee=" + employee + ", project=" + project + "]";
	}
	
	

}
