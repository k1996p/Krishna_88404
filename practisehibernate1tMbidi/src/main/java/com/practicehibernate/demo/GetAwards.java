package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Singer;
import com.practicehibernate.util.HibernateUtil;

public class GetAwards {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// get the singer detail object
		int theId = 25;
		Singer singer = session.get(Singer.class, theId);

		// print the singer
		System.out.println("singer: " + singer);

		// get awards 
		System.out.println("awards: " + singer.getAwards());

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
