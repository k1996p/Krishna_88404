package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Channel;
import com.practicehibernate.modal.Subscriber;
import com.practicehibernate.util.HibernateUtil;

public class CreateChannelSub {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// create a channel
		Channel channel = new Channel("StarSports","Sports");

		// save the channel
		System.out.println("\nSaving the channel ...");
		session.save(channel);
		System.out.println("Saved the channel: " + channel);

		// create the subscribers
		Subscriber subscriber1 = new Subscriber("John", "Doe", 20);
		Subscriber subscriber2 = new Subscriber("Mary", "Public", 23);

		// add students to the course
		channel.addSubscriber(subscriber1);
		channel.addSubscriber(subscriber2);

		// save the students
		System.out.println("\nSaving subscribers ...");
		session.save(subscriber1);
		session.save(subscriber2);
		System.out.println("Saved subscribers: " + channel.getSubscribers());
		
		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
