package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Singer;
import com.practicehibernate.modal.Song;
import com.practicehibernate.util.HibernateUtil;

public class CreateSinger {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Singer singer = new Singer("kp","pk");
		Song song = new Song("kuchbhi123","sufi123");
		
		System.out.println("Saving singer: "+ singer);
		singer.setSong(song);
		
		System.out.println("Saving Singer: " + singer);
		session.save(singer);	

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
