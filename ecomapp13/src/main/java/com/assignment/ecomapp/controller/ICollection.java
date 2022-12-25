package com.assignment.ecomapp.controller;

import java.sql.SQLException;
import java.util.List;

public interface ICollection <P>{

	List<P> findAll() throws SQLException;
	P findOne(int id) throws SQLException;
	boolean createNew(P t) throws SQLException;
	boolean findOneAndDelete(int id) throws SQLException;
	boolean findOneAndUpdate(int id,P t) throws SQLException;
	
}
