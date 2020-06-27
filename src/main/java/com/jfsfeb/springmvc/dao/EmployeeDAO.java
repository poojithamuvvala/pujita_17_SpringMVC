package com.jfsfeb.springmvc.dao;

import java.util.List;

import com.jfsfebspringmvc.dto.EmployeeBean;

public interface EmployeeDAO {
           public EmployeeBean getEmployeeDetailById(int id);
           public boolean createEmployeeInfo(EmployeeBean bean);
           public boolean deleteEmployeeInfo(int id);
           public boolean updateEmployeeInfo(EmployeeBean bean);
           public List<EmployeeBean> getAllEmployeesDetails();
           
}
