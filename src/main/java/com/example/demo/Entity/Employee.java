package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int employee_id;
		
	    private String firstName;

	   
	    private String lastName;
	    
	    private long salary;
	    
	    

	    public Employee() {
			super();
		}

		public Employee(int employee_id, String firstName, String lastName,long salaray) {
			super();
			this.employee_id = employee_id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.salary=salary;
		}

		// Getters and Setters

	    public int getEmployee_id() {
	        return employee_id;
	    }
	    

	    public long getSalary() {
			return salary;
		}

		public void setSalary(long salary) {
			this.salary = salary;
		}

		public void setEmployee_id(int employee_id) {
	        this.employee_id = employee_id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

}

