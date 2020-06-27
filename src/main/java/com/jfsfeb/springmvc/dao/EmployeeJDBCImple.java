package com.jfsfeb.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.jfsfebspringmvc.dto.EmployeeBean;

public class EmployeeJDBCImple implements EmployeeDAO {
	String url = "jdbc:mysql://localhost:3307?user=root&password=root";

	@Override
	public EmployeeBean getEmployeeDetailById(int id) {

		ResultSet resultSet = null;

		String query = "select * from demo.ems where id=?";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			EmployeeBean bean = new EmployeeBean();
			if (resultSet.next()) {
				bean.setId(resultSet.getInt("id"));
				bean.setLastName(resultSet.getString("lastName"));
				bean.setFirstName(resultSet.getString("firstName"));
				bean.setEmail(resultSet.getString("email"));
				bean.setDepartment(resultSet.getString("department"));
				bean.setSalary(resultSet.getInt("salary"));
				return bean;
			} else {
				System.out.println("employee not found!");
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {

				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}// end of getEmployeeDetailById(int id)

	@Override
	public boolean createEmployeeInfo(EmployeeBean bean) {
		// TODO Auto-generated method stub
		String query = "insert into demo.ems values(?,?,?,?,?,?)";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setInt(1, bean.getId());
			preparedStatement.setString(2, bean.getLastName());
			preparedStatement.setString(3, bean.getFirstName());
			preparedStatement.setString(4, bean.getEmail());
			preparedStatement.setString(5, bean.getDepartment());
			preparedStatement.setInt(6, bean.getSalary());
			int n = preparedStatement.executeUpdate();
			if (n != 0) {
				System.out.println("Successfully inserted!!!");
				return true;
			} else {
				System.out.println("Data already exists");
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean deleteEmployeeInfo(int id) {	
		String query = "delete from demo.ems where id=?";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0) {
				System.out.println("Succesfully Deleted!!!");
				return true;
			} else {
				System.out.println("Employee not found!");
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeBean bean) {
		// TODO Auto-generated method stub
		String query = "update demo.ems set salary=? where id=?";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setInt(1, bean.getSalary());
			preparedStatement.setInt(2, bean.getId());
			int n = preparedStatement.executeUpdate();
			if (n != 0) {
				System.out.println("Successfully Updated!!!");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<EmployeeBean> getAllEmployeesDetails() {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		String query = "select * from demo.ems";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			resultSet = preparedStatement.executeQuery();
			List<EmployeeBean> l = new ArrayList<EmployeeBean>();
			while (resultSet.next()) {
				EmployeeBean bean = new EmployeeBean();
				bean.setId(resultSet.getInt("id"));
				bean.setLastName(resultSet.getString("lastName"));
				bean.setFirstName(resultSet.getString("firstName"));
				bean.setEmail(resultSet.getString("email"));
				bean.setDepartment(resultSet.getString("department"));
				bean.setSalary(resultSet.getInt("salary"));
				l.add(bean);
			}
			if(l.isEmpty()) {
				return null;
			}
			else {
			return l;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {

			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
	}

}// end of class
