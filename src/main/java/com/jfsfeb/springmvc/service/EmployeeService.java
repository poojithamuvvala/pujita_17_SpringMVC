package com.jfsfeb.springmvc.service;

import java.util.List;

import com.jfsfebspringmvc.dto.EmployeeBean;

public interface EmployeeService {
	public EmployeeBean getEmployeeDetailById(int id);
    public boolean createEmployeeInfo(EmployeeBean bean);
    public boolean deleteEmployeeInfo(int id);
    public boolean updateEmployeeInfo(EmployeeBean bean);
    public List<EmployeeBean> getAllEmployeesDetails();
}
