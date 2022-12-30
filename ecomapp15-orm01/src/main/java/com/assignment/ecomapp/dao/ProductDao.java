package com.assignment.ecomapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.assignment.ecomapp.modal.Product;
import com.assignment.ecomapp.util.HibernateUtil;

public class ProductDao implements IDao<Product> {

	private Session session;
	private Transaction transaction;
	private Query query;
	
	public boolean createNew(Product product) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(product)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}

	@Override
	public List<Product> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Product");//select * from product
		final List<Product> productList=query.list();
		transaction.commit();
		return productList;
	}

	@Override
	public Product findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Product b where b.pId="+id);//select * from product
		final Product product=(Product) query.getSingleResult();
		transaction.commit();
		return product;
	}

	@Override
	public boolean findOneandDelete(int pId) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from Product b where b.pId=:id");
		query.setParameter("id",pId);
		final int statusDelete=query.executeUpdate();		
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if(statusDelete>0) {
			result=true;
		}
		return result;
	}

	@Override
	public boolean findOneandUpdate(int id, Product newObj) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update Product b set b.pName=:pName where pId=:pId");
		query.setParameter("pId",id);
		query.setParameter("pName",newObj.getpName());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}

	
}
