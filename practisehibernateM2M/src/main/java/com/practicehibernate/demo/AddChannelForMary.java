package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Channel;
import com.practicehibernate.modal.Subscriber;
import com.practicehibernate.util.HibernateUtil;

public class AddChannelForMary {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// get the student mary from database
		int subId = 2;
		Subscriber subscriber = session.get(Subscriber.class, subId);

		System.out.println("\nLoaded subscriber: " + subscriber);
		System.out.println("Courses: " + subscriber.getChannels());

		// create more channel
		Channel channel1 = new Channel("Discovery","nature");
		Channel channel2 = new Channel("POGO","cartoon");

		// add student to channel
		channel1.addSubscriber(subscriber);
		channel2.addSubscriber(subscriber);

		// save the channel
		System.out.println("\nSaving the channel ...");

		session.save(channel1);
		session.save(channel2);

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
