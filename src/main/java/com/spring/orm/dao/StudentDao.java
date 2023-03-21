package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entities.Student;

public interface StudentDao {

	public int add(Student std);
	public int update(Student std);
	public int delete(int id);
	public Student get(int id);
	public List<Student> getAll();
}
