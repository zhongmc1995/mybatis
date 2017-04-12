package com.zmc.annotaion;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zmc.pojo.Address;
import com.zmc.pojo.Person;
import com.zmc.util.MyBatisSqlSessionFactory;

/**
 * @author zhongmc
 * 基于mybatis注解的开发测试
 */
public class AnnotationTest {

	@Test
	public void insertTest(){
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
		Address address = new Address();
		address.setAddrId(1);
		Person person = new Person(1, "zhangsan", 20,address);
		mapper.insertPerson(person);
	}
	
	@Test
	public void updateTest(){
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
		Person person = new Person(1, "jack", 22);
		mapper.updatePerson(person);
	}
	
	@Test
	public void deleteTest(){
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
		Person person = new Person(1, "jack", 22);
		mapper.deletePerson(person.getId());
	}
	
	@Test
	public void selectTest(){
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
		Person person = mapper.findPersonById2(76);
		System.out.println(person);
	}
	
	@Test
	public void selectAddressTest(){
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
		List<Address> addresses = mapper.findAllAddrss();
		for (Address address : addresses) {
			System.out.println(address);
		}
	}
}
