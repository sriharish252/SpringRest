package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.entity.Department;

@Component
public class DepartmentDao {

	static ArrayList<Department> DEPARTMENT_LIST;
	
	@SuppressWarnings({ "unchecked", "resource" })
	public DepartmentDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList");
	}

	public List<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}
}
