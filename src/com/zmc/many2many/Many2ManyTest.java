package com.zmc.many2many;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.zmc.onetomany.Course;
import com.zmc.util.MyBatisSqlSessionFactory;

public class Many2ManyTest {
	SqlSession session = null;
	@Before
	public void setUp(){
		session = MyBatisSqlSessionFactory.openSession();
	}
	@org.junit.Test
	public void testStudentInsert(){
		
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		Student2 s2 = new Student2();
		for (int i = 1; i < 11; i++) {
			s2.setId(1);
			s2.setName("tom"+i);
			s2.setGender("male");
			s2.setGrade("大三");
			s2.setMajor("软工");
			mapper.insertStudent(s2);
		}
		session.commit();
	}
	
	@Test
	public void testCourseInsert(){
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		Course2 c2 = new Course2();
		for (int i = 0; i < 10; i++) {
			c2.setId(i);
			c2.setCourseCode("000"+i);
			c2.setCourseName(i+"号课程");
			mapper.insertCourse(c2);
		}
		session.commit();
	}
	
	@Test
	public void testStuSelect()	{
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		Student2 student2 = mapper.getStudentById(2);
		System.out.println(student2);
	}
	
	@Test
	public void testCourseSelect()	{
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		Course2 course = mapper.getCourseById(12);
		System.out.println(course);
	}
	
	@Test
	public void testStuSelectCourse(){
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		Student2 student2 = mapper.getStudentById(3);
		Course2 course2 = mapper.getCourseById(14);
		mapper.studentSelectCourse(student2,course2);
		session.commit();
	}
	
	@Test
	public void testSelectStuOnCondition(){
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		List<Student2> student2s = mapper.getStudentByIdOnCondition(4);
		for (Student2 student2 : student2s) {
			System.out.println(student2);
		}
	}
	@Test
	public void testStuWithCourse(){
		Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
		Student2 student2 = mapper.getStudentByIdWithCourses(2);
		System.out.println(student2);
	}
}
