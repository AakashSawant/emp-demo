package com.example.demo.service;

import java.util.Collection;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.EmployeeModel;

public interface EmployeeService {

	void addEmployee(EmployeeDto dto);

	Collection<EmployeeModel> getAllEmployees();

	EmployeeModel EmployeeById(Long id);

	void updateEmployee(EmployeeDto dto, Long id);

	void deleteEmployee(Long id);

}
