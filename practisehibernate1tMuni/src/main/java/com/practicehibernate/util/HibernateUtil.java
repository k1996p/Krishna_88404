package com.practicehibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources().buildMetadata(serviceRegistry);
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}

		return sessionFactory;
	}

	public static Session getSession() {
		if (session == null || !session.isOpen()) {
			session = getSessionFactory().openSession();
		}
		return session;
	}

	public static void close() {
		if (session.isOpen()) {
			session.close();
		}
		if (sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}
}
