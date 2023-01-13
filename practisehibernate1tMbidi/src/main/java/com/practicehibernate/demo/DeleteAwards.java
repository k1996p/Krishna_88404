package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Award;
import com.practicehibernate.util.HibernateUtil;

public class DeleteAwards {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// get the awards detail object
		int theId = 30;
		Award award = session.get(Award.class, theId);

		// now let's delete the awards
		System.out.println("Deleting awards: " + award);
		
		session.delete(award);

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
