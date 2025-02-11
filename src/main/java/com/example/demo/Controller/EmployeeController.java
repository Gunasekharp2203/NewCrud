package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Employees;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Requests.EmployeeUpdateRequest;
import com.example.demo.ServiceImpl.EmployeeServiceImpl;

@RestController

public class EmployeeController {
	
	@Autowired(required=true)
	public EmployeeServiceImpl emimp;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable int id){
		 try {
	            Employees employee = emimp.getEmployeesById(id);
	            return ResponseEntity.ok(employee);
	        } catch (ResourceNotFoundException e) {
	        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!");
	        }
	}
	
	
	
	@GetMapping("/employees/all")
	public List<Employees>findAllEmployees(){
		return emimp.findAll();
	}
	
	@PostMapping("/add/employee")
	public ResponseEntity<String>addEmployee(@RequestBody Employees employee){
		try {
		emimp.addEmployee(employee);
			return new ResponseEntity<>("Record created successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Failed to create record", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/emp/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id,@RequestBody EmployeeUpdateRequest request) {
		 try {
	            emimp.updateEmployee(request, id);
	            return ResponseEntity.ok("Employee updated successfully!");
	        } catch (ResourceNotFoundException ex) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!");
	        } catch (Exception ex) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("An error occurred while updating the employee.");
	        }
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
		try{
			emimp.deleteEmployeeById(id);
			return ResponseEntity.ok("Deleted Successfully");
		}catch(ResourceNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
	}
	

	

}
