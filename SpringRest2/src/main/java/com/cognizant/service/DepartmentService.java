package com.cognizant.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Department;
import com.cognizant.dao.DepartmentDao;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao department;

	public List<Department> getAllDepartments() {
		return department.getAllDepartments();
	}

}