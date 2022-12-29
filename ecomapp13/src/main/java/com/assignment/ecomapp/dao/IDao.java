package com.assignment.ecomapp.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<P> {
	
	List<P> findAll() throws SQLException;
	P findOne(int id) throws SQLException;
	boolean createNew(P t) throws SQLException;
	boolean findOneAndDelete(int id) throws SQLException;
	boolean findOneAndUpdate(int id,P t) throws SQLException;

}
