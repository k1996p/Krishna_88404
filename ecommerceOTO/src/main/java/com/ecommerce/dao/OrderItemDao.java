package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.model.OrderItem;
import com.ecommerce.util.HibernateUtil;

public class OrderItemDao implements IDao<OrderItem> {

	private Session session;
	private Transaction transaction;
	private Query query;

	public boolean createNew(OrderItem orderItem) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(orderItem) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	}

	@Override
	public List<OrderItem> findAll() {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from OrderItem");// select * from orderItem
		final List<OrderItem> productList = query.list();
		transaction.commit();
		return productList;
	}

	@Override
	public OrderItem findOne(int id) {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from OrderItem b where b.itemId=" + id);// select * from orderItem
		final OrderItem orderItem = (OrderItem) query.getSingleResult();
		transaction.commit();
		return orderItem;
	}

	@Override
	public boolean findOneandDelete(int itemId) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from OrderItem b where b.itemId=:id");
		query.setParameter("id", itemId);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean findOneandUpdate(int id, OrderItem newObj) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update OrderItem b set b.itemQuantity=:itemQuantity where itemId=:itemId");
		query.setParameter("itemId", id);
		query.setParameter("itemQuantity", newObj.getItemQuantity());
		final int statusUpdate = query.executeUpdate();
		transaction.commit();
		if (statusUpdate > 0) {
			result = true;
		}
		return result;
	}
}
