package com.practicehibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Student;
import com.practicehibernate.util.HibernateUtil;

public class CreateStudent {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// create a student object
		System.out.println("Creating new student object...");
		Student student = new Student("krishna", "prasad", "kp@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		session.save(student);

		// reading the student
		System.out.println("reading students");
		Student myStudent = session.get(Student.class, student.getId());

		System.out.println("Get complete: " + myStudent);

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
