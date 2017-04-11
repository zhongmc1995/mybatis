package com.zmc.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zmc.pojo.PhoneNumber;
import com.zmc.pojo.Student;
import com.zmc.pojo.StudentMapper;
import com.zmc.util.MyBatisSqlSessionFactory;

public class StudentTest {
	public StudentTest(){}
	
	@Test
	public void testInsert(){
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		Configuration configuration = sqlSessionFactory.getConfiguration();
		SqlSession session = sqlSessionFactory.openSession();
		
		//第一种执行sql语句的方式  通过XxxxMapper接口的实现类对象来调用
		//动态获得XxxxMapper接口的实现类
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		PhoneNumber phoneNumber = new PhoneNumber("0086", "0521", "12345");
		mapper.insertStudent(new Student(5,"tom","123@.qq.com",new Date(),phoneNumber));
		
		//第二种执行sql语句的方式  执行调用XxxxMapper.xml中写好的sql语句
		//也可以【不通过】Mapper接口执行映射的SQL
		//然而，使用 Mapper接口是最佳实践
		//Student student = (Student)session.selectOne("com.zmc.pojo.StudentMapper.findStudentById",1);
		//System.out.println(student);
		session.commit();
	}
	@Test
	public void testSelect(){
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		/*StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Student> students = studentMapper.findAllStudents();session.selectList("com.zmc.pojo.StudentMapper.findAllStudents");
		for (Student student : students) {
			System.out.println(student);
		}*/
		
		//另一种方式
		Student s = session.selectOne("com.zmc.pojo.StudentMapper.findStudentInfoById",3);
		System.out.println(s);
		
		
	}
	
	
	
}
