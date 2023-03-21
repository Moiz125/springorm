package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDaoImpl;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDaoImpl studentDao = context.getBean("studentDaoImpl", StudentDaoImpl.class);
		Student student = new Student(3, "Ali", "66");

		boolean condition = true;
 		while (condition) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Press 1 to add Student");
			System.out.println("Press 2 to delete Student");
			System.out.println("Press 3 to update Student");
			System.out.println("Press 4 to get one Student");
			System.out.println("Press 5 to get all Student");
			System.out.println("Press 6 to exit");
			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					System.out.println(studentDao.add(student));

					break;
				case 2:
					System.out.print(studentDao.delete(4));
					break;
				case 3:
					System.out.println(studentDao.update(student));
					break;
				case 4:
					System.out.println(studentDao.get(2));

					break;
				case 5:
					System.out.println(studentDao.getAll());
					break;
				case 6:
					condition = false;
					break;

				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid input try again");
				System.out.println(e.getMessage());
			}
			
		}
 		System.out.println("Application closed...");

	}
}
