package com.example.demo.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.ServiceImpl;


@RestController
public class Controller {
	
	@Autowired(required=true)
	public ServiceImpl servicerep;
	
	@GetMapping("/user/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> emplis=servicerep.getAllemp();
		return emplis;
		
	}
	@GetMapping("/hello")
	public String show() {
		return "Hello world";
	}
	
	
	@GetMapping("/user/firstname/{fname}")
	public List<Employee> getEmpbyFname(@PathVariable String fname) {
		List<Employee> e5= servicerep.getByFirstName(fname);
		return e5;
	}
	
	@GetMapping("/user/lastname")
	public Employee getEmpByLname(@RequestParam String lname) {
		Employee e1=servicerep.getByLastName(lname);
		return e1;
		
	}
	
	@PostMapping("/user/employees")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		Employee newEmployee=servicerep.addEmployee(employee);
		if(newEmployee!=null) {
			return new ResponseEntity<>("Record Created Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
		
	}
	
	 @PutMapping("/user/fn/{id}")
	    public ResponseEntity<Employee> updateFirstName(@PathVariable int id, @RequestBody String firstName) {
	        Employee updatedEmployee = servicerep.updateFirstName(id, firstName);
	        
	        if (updatedEmployee != null) {
	            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @PutMapping("/user/an/{id}")
	 public ResponseEntity<Employee> updateLastName(@PathVariable int id, @RequestBody String lastName) {
		 Employee uemp=servicerep.updateLastName(id, lastName);
		 if(uemp!=null) {
			 return new ResponseEntity<>(uemp,HttpStatus.OK);
		 }else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 
	 }
	 
	 @DeleteMapping("/user/{id}")
	 public ResponseEntity<String>deleteById(@PathVariable int id){
		 try {
			 servicerep.deleteById(id);
			 return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
			 
		 }catch(Exception e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		
		 
	 }

}
