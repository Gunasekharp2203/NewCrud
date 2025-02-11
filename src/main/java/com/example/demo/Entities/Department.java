package com.example.demo.Entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="department_name")
	private String deptName;
	
	//@OneToMany(mappedBy = "department")
   // private Set<Employees> employees;
	
	

	public Department() {
		super();
	}

	
	public Department( String deptName /*, Set<Employees> employees*/) {
		super();
		this.deptName = deptName;
		//this.employees = employees;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



//	public Set<Employees> getEmployees() {
//		return employees;
//	}
//
//
//
//	public void setEmployees(Set<Employees> employees) {
//		this.employees = employees;
//	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName +/* ", employees=" + employees +*/ "]";
	}



	



	
	
	

}
