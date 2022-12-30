package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.model.Customer;
import com.ecommerce.util.HibernateUtil;

public class CustomerDao implements IDao<Customer> {

	private Session session;
	private Transaction transaction;
	private Query query;

	public boolean createNew(Customer customer) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(customer) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	}

	@Override
	public List<Customer> findAll() {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Customer");// select * from customer
		final List<Customer> customerList = query.list();
		transaction.commit();
		return customerList;
	}

	@Override
	public Customer findOne(int id) {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Customer b where b.custId=" + id);// select * from customer
		final Customer customer = (Customer) query.getSingleResult();
		transaction.commit();
		return customer;
	}

	@Override
	public boolean findOneandDelete(int custId) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from Customer b where b.custId=:id");
		query.setParameter("id", custId);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean findOneandUpdate(int id, Customer newObj) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update Customer b set b.custName=:custName where custId=:custId");
		query.setParameter("custId", id);
		query.setParameter("custName", newObj.getCustName());
		final int statusUpdate = query.executeUpdate();
		transaction.commit();
		if (statusUpdate > 0) {
			result = true;
		}
		return result;
	}


}
