package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Award;
import com.practicehibernate.modal.Singer;
import com.practicehibernate.util.HibernateUtil;

public class CreateAwards {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// get the singer detail object
		int theId = 25;
		Singer singer = session.get(Singer.class, theId);
		
		//create award
		Award award1=new Award("ifa-award");
		Award award2=new Award("iiifa-award");
		
		//add award  to singer
		singer.add(award1);
		singer.add(award2);
		
		//save the award
		session.save(award1);
		session.save(award2);

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
