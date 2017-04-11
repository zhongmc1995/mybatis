package com.zmc.onetomany;

import org.apache.ibatis.session.SqlSession;

import com.zmc.util.MyBatisSqlSessionFactory;

public class Test {
	@org.junit.Test
	public void tutorTest()	{
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		One2ManyMapper mapper = session.getMapper(One2ManyMapper.class);
		Tutor tutor = mapper.findTutorById(2);
		System.out.println(tutor);
	}
}
