package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spring.orm.entities.Student;


//@Component
@Transactional
public class StudentDaoImpl implements StudentDao{
	
//	@Autowired
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	public int add(Student std) {
		// insert
		Integer result = (Integer)this.hibernateTemplate.save(std);
		return result;
	}

	public int update(Student std) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(std);;
		return 1;
	}

	public int delete(int id) {
		Student student = this.hibernateTemplate.get(Student.class,id);
		this.hibernateTemplate.delete(student);
		return 1;
	}

	public Student get(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		return student;
	}

	public List<Student> getAll() {
		List<Student> student  = this.hibernateTemplate.loadAll(Student.class);
		return student;
	}

}
