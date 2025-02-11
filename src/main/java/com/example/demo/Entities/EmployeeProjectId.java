package com.example.demo.Entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeProjectId {
	
	private int employeeId;
	private int projectId;
	
	public EmployeeProjectId() {
		super();
	}
	
	public EmployeeProjectId(int employeeId, int projectId) {
		super();
		this.employeeId = employeeId;
		this.projectId = projectId;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	  @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        EmployeeProjectId that = (EmployeeProjectId) o;
	        return Objects.equals(employeeId, that.employeeId) &&
	                Objects.equals(projectId, that.projectId);
	    }

	@Override
	public int hashCode() {
		return Objects.hash(employeeId,projectId);
	}
	  
	  

		
	
	
	

}
