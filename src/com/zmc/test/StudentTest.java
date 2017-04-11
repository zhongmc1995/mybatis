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
		
		//��һ��ִ��sql���ķ�ʽ  ͨ��XxxxMapper�ӿڵ�ʵ�������������
		//��̬���XxxxMapper�ӿڵ�ʵ����
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		PhoneNumber phoneNumber = new PhoneNumber("0086", "0521", "12345");
		mapper.insertStudent(new Student(5,"tom","123@.qq.com",new Date(),phoneNumber));
		
		//�ڶ���ִ��sql���ķ�ʽ  ִ�е���XxxxMapper.xml��д�õ�sql���
		//Ҳ���ԡ���ͨ����Mapper�ӿ�ִ��ӳ���SQL
		//Ȼ����ʹ�� Mapper�ӿ������ʵ��
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
		
		//��һ�ַ�ʽ
		Student s = session.selectOne("com.zmc.pojo.StudentMapper.findStudentInfoById",3);
		System.out.println(s);
		
		
	}
	
	
	
}
