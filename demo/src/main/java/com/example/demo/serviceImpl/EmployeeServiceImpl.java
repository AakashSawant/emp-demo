package com.example.demo.serviceImpl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.constants.MessageConstants;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
@Transactional(isolation = Isolation.READ_UNCOMMITTED, rollbackFor = RuntimeException.class)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void addEmployee(EmployeeDto dto) {

		EmployeeModel emp = null;
		try {
			emp = this.repo.findEmployeeModelByMobileNo(dto.getMobileNo());
			if (emp == null) {
				emp = new EmployeeModel();
				emp.setAddress(dto.getAddress());
				emp.setFirstName(dto.getFirstName());
				emp.setLastName(dto.getLastName());
				emp.setMobileNo(dto.getMobileNo());
				this.repo.save(emp);
			} else {
				throw new RuntimeException(MessageConstants.EMPLOAYEE_ALREADY_EXIST);
			}

		} finally {
			// TODO: handle finally clause
		}

	}

	@Override
	public Collection<EmployeeModel> getAllEmployees() {

		return this.repo.getALL();
	}

	@Override
	public EmployeeModel EmployeeById(Long id) {
		Optional<EmployeeModel> emp = this.repo.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			throw new RuntimeException(MessageConstants.EMPLOAYEE_NOT_FOUND);
		}
	}

	@Override
	public void updateEmployee(EmployeeDto dto, Long id) {
		Optional<EmployeeModel> emp = this.repo.findById(id);
		if (emp.isPresent()) {
			EmployeeModel empUpdate = emp.get();
			empUpdate.setAddress(dto.getAddress());
			empUpdate.setFirstName(dto.getFirstName());
			empUpdate.setLastName(dto.getLastName());
			empUpdate.setMobileNo(dto.getMobileNo());
			this.repo.save(empUpdate);
		} else {
			throw new RuntimeException(MessageConstants.EMPLOAYEE_NOT_FOUND);
		}
	}

	@Override
	public void deleteEmployee(Long id) {
		Optional<EmployeeModel> emp = this.repo.findById(id);
		if (emp.isPresent()) {
			this.repo.deleteById(id);
		} else {
			throw new RuntimeException(MessageConstants.EMPLOAYEE_NOT_FOUND);
		}
	}

}
