package com.zmc.pojo;

import java.util.List;


public interface StudentMapper {
	List<Student> findAllStudents();
	
	Student findStudentById(Integer id);
	
	void insertStudent(Student student);
	Student findStudentInfoById(Integer id);
}
