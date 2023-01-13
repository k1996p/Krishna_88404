package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Song;
import com.practicehibernate.util.HibernateUtil;

public class DeleteSongReviews {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// get the song detail object
		int theId = 30;
		Song song = session.get(Song.class, theId);

		// now let's delete the song
		System.out.println("Deleting song: " + song);
		
		session.delete(song);

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
