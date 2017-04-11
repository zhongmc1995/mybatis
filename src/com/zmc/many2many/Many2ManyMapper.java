package com.zmc.many2many;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zmc.onetomany.Course;

public interface Many2ManyMapper {
	//����student����
	public void insertStudent(Student2 student);
	//����course����
	public void insertCourse(Course2 course);
	//ͨ��id��ѯѧ��
	public Student2 getStudentById(Integer id);
	//ͨ��id��ѯ�γ�
	public Course2 getCourseById(Integer id);
	
	//ѧ��xѡ��y
	public void studentSelectCourse(Student2 s,Course2 c);
	//��ѯ��ָ��idֵС��ѧ����Ϣ
	public List<Student2> getStudentByIdOnCondition(Integer id);
	//��ѯstudent������ѯ����ѡ��course������װ�������Ķ���
	public Student2 getStudentByIdWithCourses(Integer id);
}	
