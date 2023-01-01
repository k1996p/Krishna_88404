package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Singer;
import com.practicehibernate.modal.Song;
import com.practicehibernate.util.HibernateUtil;

public class DeleteSongDemo {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// get the song detail object
		int theId = 24;
		Song song = session.get(Song.class, theId);

		// print the song
		System.out.println("song: " + song);

		// print the associated singer
		System.out.println("the associated singer: " + song.getSinger());
		
		//break bi-di link
		//song.getSinger().setSong(null);

		// now let's delete the song
		System.out.println("Deleting song: " + song);
		session.delete(song);

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
