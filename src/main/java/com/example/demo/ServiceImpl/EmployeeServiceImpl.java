package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.Employees;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repository.DepartmentRepo;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Requests.EmployeeUpdateRequest;
import com.example.demo.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public Employees getEmployeesById(int id) {
		return employeeRepo.findById(id).orElseThrow(()->
			 new ResourceNotFoundException("Employee not found!"));
	}

	@Override
	public List<Employees> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employees addEmployee(Employees employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public Employees updateEmployee(EmployeeUpdateRequest request, int id) {
		return employeeRepo.findById(id)
				.map(oldEmployee->updateExistingEmployee(oldEmployee, request))
				.map(employeeRepo :: save)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found!"));
	}
	
	private Employees updateExistingEmployee(Employees existEmployee,EmployeeUpdateRequest request) {
		 Department department =departmentRepo.findByDeptName(request.getDepartment().getDeptName())
		            .orElseGet(() -> {
		            	 Department newDepartment = new Department(request.getDepartment().getDeptName());
		                 return departmentRepo.save(newDepartment);
		            });
		    existEmployee.setFirstName(request.getFirstName());
		    existEmployee.setLastName(request.getLastName());
		    existEmployee.setDepartment(department);
		    return existEmployee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepo.findById(id).ifPresentOrElse(employeeRepo::delete,
				()->{ throw new ResourceNotFoundException("Employee not found!");}
				);
		
	}

}
