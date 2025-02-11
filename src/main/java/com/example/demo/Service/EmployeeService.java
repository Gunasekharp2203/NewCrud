package com.example.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Entities.Employees;
import com.example.demo.Requests.EmployeeUpdateRequest;


public interface EmployeeService {
	
     Employees getEmployeesById(int id);
	
	 List<Employees>findAll();
	
	public Employees addEmployee(Employees employee);
	
	public Employees updateEmployee(EmployeeUpdateRequest request, int id);
	
	public void deleteEmployeeById(int id);

}
