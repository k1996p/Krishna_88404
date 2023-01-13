package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Singer;
import com.practicehibernate.modal.Song;
import com.practicehibernate.util.HibernateUtil;

public class GetSongReviews {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// get the song detail object
		int theId = 25;
		Song song = session.get(Song.class, theId);

		// print the song
		System.out.println("singer: " + song);

		// get reviews 
		System.out.println("awards: " + song.getReviews());

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
