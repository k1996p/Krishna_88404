package com.ecommerce.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecommerce.model.OrderItem;


public class OrderItemDaoTest {

	private OrderItem orderItem;
	private OrderItemDao orderItemDao;

	@BeforeEach()
	public void beforeEach() {
		orderItem = new OrderItem(5);
		orderItemDao = new OrderItemDao();
	}

	@Test
	public void testCreateBook() {
		Assertions.assertTrue(orderItemDao.createNew(orderItem));
	}

	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(orderItemDao.findAll());
	}

	@Test
	public void testFindOneNotNull() {
		orderItem = orderItemDao.findOne(4);
		Assertions.assertNotNull(orderItem);
		System.out.println("id=4 |" + orderItem);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(orderItemDao.findOneandDelete(6));
	}

	@Test
	public void testFindOneAndUpdate() {
		orderItem.setItemQuantity(9);
		Assertions.assertTrue(orderItemDao.findOneandUpdate(7, orderItem));
	}
}
