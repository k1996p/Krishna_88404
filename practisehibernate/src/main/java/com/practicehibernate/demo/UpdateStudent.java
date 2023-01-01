package com.practicehibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Student;
import com.practicehibernate.util.HibernateUtil;

public class UpdateStudent {

	public static void main(String[] args) {

		int studentId = 1;

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// retrieve student based on the id: primary key
		System.out.println("\nGetting student with id: " + studentId);

		Student myStudent = session.get(Student.class, studentId);

		System.out.println("Updating student...");
		myStudent.setFirstname("Krishna");
		
//------------------------------------------------------------//
		
		// update email for all students
		System.out.println("Update email for all students");

		session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}
}
