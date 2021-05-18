package com.example.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

	@Query("SELECT EMP FROM EmployeeModel AS EMP")
	Collection<EmployeeModel> getALL();
	
	public EmployeeModel findEmployeeModelByMobileNo(Long mobileNo);
}
