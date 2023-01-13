package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Subscriber;
import com.practicehibernate.util.HibernateUtil;

public class GetChannelForMary {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// get the student from database
		int subId = 1;
		Subscriber subscriber = session.get(Subscriber.class, subId);

		System.out.println("\nLoaded subscriber: " + subscriber);
		System.out.println("channel: " + subscriber.getChannels());

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
