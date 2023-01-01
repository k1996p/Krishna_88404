package com.practicehibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practicehibernate.modal.Student;
import com.practicehibernate.util.HibernateUtil;

public class ReadStudent {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		// query students
		List<Student> theStudents = session.createQuery("from Student").getResultList();

		// display the students
		displayStudentList(theStudents);
		
		transaction.commit();
		System.out.println("Done!");

		HibernateUtil.close();

	}

	private static void displayStudentList(List<Student> theStudents) {
		for(Student student:theStudents) {
			System.out.println(student);
		}
	}
}

