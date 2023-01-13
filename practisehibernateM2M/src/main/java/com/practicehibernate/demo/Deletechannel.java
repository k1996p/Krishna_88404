package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Channel;
import com.practicehibernate.util.HibernateUtil;

public class Deletechannel {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// get the channel  from db
		int channelId = 10;
		Channel channel = session.get(Channel.class, channelId);

		// delete the course
		System.out.println("Deleting channel: " + channel);

		session.delete(channel);

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
