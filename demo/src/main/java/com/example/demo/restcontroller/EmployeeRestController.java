package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.MessageConstants;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.responseDto.ResponseDto;
import com.example.demo.responseDto.ResponseMessageDto;
import com.example.demo.service.EmployeeService;

@RequestMapping("/api/employee")
@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseDto addEmployee(@RequestBody EmployeeDto dto) {
		service.addEmployee(dto);
		return new ResponseDto(Boolean.TRUE, Boolean.FALSE,
				new ResponseMessageDto(MessageConstants.ADD_EMPLOYEED_MESSAGE));
	}

	@GetMapping
	public ResponseDto AllEmployee() {
		return new ResponseDto(Boolean.TRUE, Boolean.FALSE, service.getAllEmployees());
	}

	@GetMapping("{id}")
	public ResponseDto EmployeeById(@PathVariable("id") Long id) {
		return new ResponseDto(Boolean.TRUE, Boolean.FALSE, service.EmployeeById(id));
	}

	@PutMapping("{id}")
	public ResponseDto updateEmployee(@RequestBody EmployeeDto dto, @PathVariable("id") Long id) {
		service.updateEmployee(dto, id);
		return new ResponseDto(Boolean.TRUE, Boolean.FALSE,
				new ResponseMessageDto(MessageConstants.UPDATE_EMPLOYEED_MESSAGE));
	}

	@DeleteMapping("{id}")
	public ResponseDto deleteEmployee(@PathVariable("id") Long id) {
		service.deleteEmployee(id);
		return new ResponseDto(Boolean.TRUE, Boolean.FALSE,
				new ResponseMessageDto(MessageConstants.DELETE_EMPLOYEED_MESSAGE));
	}
}
