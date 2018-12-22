package com.ab9.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ab9.dao.CustomerDao;
import com.ab9.entities.CustomerEntity;
import com.ab9.util.AppUtil;

@Repository()
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCustomer(CustomerEntity customerEntity) {
		// TODO Auto-generated method stub
				Session session = null;
				Transaction tx = null;
				try {
					// customerEntity.setCustomerName("kishor");
					session = sessionFactory.openSession();
					tx = session.beginTransaction();
					session.save(customerEntity);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					AppUtil.cleanUpResources(session, tx);
				}
				return false;
	}

	public CustomerEntity getCustomer(int customerId) {
		Session session = null;
		Transaction tx=null;
		CustomerEntity customerEntity = null;
		try {
			// customerEntity.setCustomerName("kishor");
			session = sessionFactory.openSession();
			tx=session.beginTransaction();
			customerEntity = session.get(CustomerEntity.class, customerId);
			if (customerEntity == null) {
				System.out.println("customer id:" + customerId + " not present");
				return null;
			}
			return customerEntity;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AppUtil.cleanUpResources(session, tx);
		}
		return null;
	}

	public CustomerEntity deleteCustomer(int customerId) {
		Session session = null;
		Transaction tx = null;
		CustomerEntity customerEntity = null;
		customerEntity = getCustomer(customerId);
		if (customerEntity == null) {
			System.out.println("customer not present");
			return null;
		}
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(customerEntity);
			return customerEntity;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AppUtil.cleanUpResources(session, tx);
		}
		return null;
	}

	public CustomerEntity updateCustomer(CustomerEntity customerEntity) {

		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.merge(customerEntity);
			return customerEntity;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			AppUtil.cleanUpResources(session, tx);
		}
		return null;
	}

	public List<CustomerEntity> getAllCustomers() {
		// TODO Auto-generated method stub
		return sessionFactory.openSession().createCriteria(CustomerEntity.class).list();
	}

}
