package com.jfsfeb.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jfsfebspringmvc.dto.EmployeeBean;

public class EmployeeHybernateImpl implements EmployeeDAO {

	@Override
	public EmployeeBean getEmployeeDetailById(int id) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = entityManagerFactory.createEntityManager();
			EmployeeBean record=manager.find(EmployeeBean.class, id);
			System.out.println("ID--->" + record.getId());
			System.out.println("LastName--->" + record.getLastName());
			System.out.println("FirstName-->" + record.getFirstName());
			System.out.println("email--->" + record.getEmail());
			System.out.println("department-->" + record.getDepartment());
			System.out.println("salary-->" + record.getSalary());
			manager.close();
			entityManagerFactory.close();
			return record;
		} catch (Exception e) {
			e.printStackTrace();
           
		}

		
		 return null;
	}

	@Override
	public boolean createEmployeeInfo(EmployeeBean bean) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;

		try {
		entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction=manager.getTransaction();
        transaction.begin();
        manager.persist(bean);
        transaction.commit();
        System.out.println("Record saved");
        manager.close();
		entityManagerFactory.close();
        return true;
		} catch (Exception e) {
			e.printStackTrace();
            
		}

		
		return false;
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			EmployeeBean employeeInfo = entityManager.find(EmployeeBean.class, id);
			entityManager.remove(employeeInfo);
			System.out.println("record is successfully deleted!!!");
			entityTransaction.commit();
			entityManager.close();
			entityManagerFactory.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeBean bean) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeeBean bean1 = manager.find(EmployeeBean.class, bean.getId());
			bean1.setDepartment(bean.getDepartment());
			System.out.println("Record updated");
			transaction.commit();
			manager.close();
			entityManagerFactory.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		}
		
		return false;
	
	
	}

	@Override
	public List<EmployeeBean> getAllEmployeesDetails() {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select e from EmployeeBean e";
			Query query = manager.createQuery(jpql);
			List<EmployeeBean> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			entityManagerFactory.close();
			return recordList;
			
		
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		}

		return null;
	}

}
