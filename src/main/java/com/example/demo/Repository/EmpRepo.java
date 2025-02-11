package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer>{
	@Query("select e1 from Employee e1 where e1.firstName = :fname")
	public List<Employee> findByfirstName(@RequestParam String fname);
	
	@Query("select e1 from Employee e1 where e1.lastName=:lname")
	public Employee findEmployeeByLastName(@RequestParam String lname);

	
}
