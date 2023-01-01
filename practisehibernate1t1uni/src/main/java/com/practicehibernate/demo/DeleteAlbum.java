package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Singer;
import com.practicehibernate.modal.Song;
import com.practicehibernate.util.HibernateUtil;

public class DeleteAlbum {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// get Singer by primary key / id
		int theId = 21;
		Singer singer = session.get(Singer.class, theId);

		System.out.println("Found singer: " + singer);
		// delete the instructors
		if (singer != null) {

			System.out.println("Deleting: " + singer);

			// Note: will ALSO delete associated "details" object
			// because of CascadeType.ALL

			session.delete(singer);
		}
		
		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
