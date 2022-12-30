package com.assignment.ecomapp.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
	
	 boolean createNew(T obj);
	 List<T> findAll();
	 T findOne(int id);
	 boolean findOneandDelete(int id);
	 boolean findOneandUpdate(int id,T newObj);

}
