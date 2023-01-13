package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Review;
import com.practicehibernate.modal.Singer;
import com.practicehibernate.modal.Song;
import com.practicehibernate.util.HibernateUtil;

public class CreateSongReview {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		int theId = 41;
		Song song = session.get(Song.class, theId);
		
		song.addReview(new Review("Good Song"));
		song.addReview(new Review("Loved Song"));
		song.addReview(new Review("My Favorite Song"));
		
		System.out.println("Saving Song");
		System.out.println(song);
		System.out.println(song.getReviews());
		
		session.save(song);

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
