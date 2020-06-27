package com.jfsfeb.springmvc.service;

import java.util.List;

import com.jfsfeb.springmvc.dao.EmployeeDAO;
import com.jfsfeb.springmvc.dao.EmployeeHybernateImpl;
import com.jfsfebspringmvc.dto.EmployeeBean;

public class EmployeeServiceHybernate implements EmployeeService {

	EmployeeDAO dao=new EmployeeHybernateImpl();
	@Override
	public EmployeeBean getEmployeeDetailById(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeDetailById(id);
	}

	@Override
	public boolean createEmployeeInfo(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return dao.createEmployeeInfo(bean);
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployeeInfo(id);
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return dao.updateEmployeeInfo(bean);
	}

	@Override
	public List<EmployeeBean> getAllEmployeesDetails() {
		// TODO Auto-generated method stub
		return dao.getAllEmployeesDetails();
	}

}
