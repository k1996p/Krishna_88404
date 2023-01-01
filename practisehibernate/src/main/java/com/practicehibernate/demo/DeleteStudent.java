package com.practicehibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Student;
import com.practicehibernate.util.HibernateUtil;

public class DeleteStudent {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// delete student id=2
		System.out.println("Deleting student id=2");
		session.createQuery("delete from Student where id=2").executeUpdate();

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
