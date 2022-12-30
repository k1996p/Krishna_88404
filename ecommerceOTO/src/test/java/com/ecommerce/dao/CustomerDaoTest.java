package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.Customer;
import com.ecommerce.util.HibernateUtil;

public class CustomerDaoTest {

	private Customer customer;
	private CustomerDao customerDao;

	@BeforeEach()
	public void beforeEach() {
		customer = new Customer("nike-Shoe", 200.00,"kp@gmail.com");
		customerDao = new CustomerDao();
	}

	@Test
	public void testCreateBook() {
		Assertions.assertTrue(customerDao.createNew(customer));
	}

	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(customerDao.findAll());
	}

	@Test
	public void testFindOneNotNull() {
		customer = customerDao.findOne(4);
		Assertions.assertNotNull(customer);
		System.out.println("id=4 |" + customer);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(customerDao.findOneandDelete(6));
	}

	@Test
	public void testFindOneAndUpdate() {
		customer.setCustName("wrong-shoe");
		Assertions.assertTrue(customerDao.findOneandUpdate(7, customer));
	}
}
