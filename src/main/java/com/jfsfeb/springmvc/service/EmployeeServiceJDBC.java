package com.jfsfeb.springmvc.service;

import java.util.List;

import com.jfsfeb.springmvc.dao.EmployeeDAO;
import com.jfsfeb.springmvc.dao.EmployeeJDBCImple;
import com.jfsfebspringmvc.dto.EmployeeBean;

public class EmployeeServiceJDBC implements EmployeeService {
	EmployeeDAO dao = new EmployeeJDBCImple();

	@Override
	public EmployeeBean getEmployeeDetailById(int id) {

		return dao.getEmployeeDetailById(id);
	}

	@Override
	public boolean createEmployeeInfo(EmployeeBean bean) {

		return dao.createEmployeeInfo(bean);
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {

		return dao.deleteEmployeeInfo(id);
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeBean bean) {

		return dao.updateEmployeeInfo(bean);
	}

	@Override
	public List<EmployeeBean> getAllEmployeesDetails() {

		return dao.getAllEmployeesDetails();
	}

}
