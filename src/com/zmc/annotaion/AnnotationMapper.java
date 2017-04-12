package com.zmc.annotaion;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.zmc.pojo.Address;
import com.zmc.pojo.Person;

public interface AnnotationMapper {
	
	/*
	 * �Զ���������

		����ʹ�� @Optionsע���userGeneratedKeys��keyProperty���������ݿ���� auto_increment�����������е�ֵ��Ȼ�����ɵ�ֵ���õ������������������С�

		@Insert("insert into students(name,email,addr_id, phone) 
				values(#{name},#{email},#{address.addr Id},#{phone})") 
		@Options(useGeneratedKeys = true, keyProperty = "studId") 
		int insertStudent(Student student); 

		����STUD_ID��ֵ����ͨ��MySQL���ݿ��Զ����ɡ��������ɵ�ֵ���ᱻ���õ�student�����studId�����С�
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class); 
		mapper.insertStudent(student); 
		int studentId = student.getStudId(); 
		
		��һЩ���ݿ���Oracle������֧��AUTO_INCREMENT�����ԣ���ʹ�����У�SEQUENCE��������������ֵ��
		���ǿ���ʹ�� @SelectKeyע����Ϊ����SQL�����ָ������ֵ����Ϊ�����е�ֵ������������һ����ΪSTUD_ID_SEQ������������STUD_ID����ֵ��
		 
		@Insert("insert into students(stud_id,name,email,addr_id,phone) values(#{studId},#{name},#{email},#{address.addrId},#{phone})") 
		@SelectKey(statement="select my_seq.nextval from dual",  
		keyProperty="studId", resultType=int.class, before=true) 
		int insertStudent(Student student); 

		��������ʹ���� @SelectKey����������ֵ�����Ҵ洢����student�����studId�����ϡ���������������before=true,����佫����ִ��INSERT���֮ǰִ��.

		@Insert("insert into students(name,email,addr_id, phone)  
		values(#{name},#{email},#{address.addrId},#{phone})") 
		@SelectKey(statement="select my_seq.currval from dual",  
		keyProperty="studId", resultType=int.class, before=false) 
		int insertStudent(Student student); 
	 * */
	/*@Insert(value="insert into person(id,name,age) values(#{id},#{name},#{age})")*/
	@Insert(value="insert into person(id,name,age,addr_id) values(#{id},#{name},#{age},#{address.addrId})")
	@SelectKey(keyProperty="id",statement="select my_seq.nextval from dual",resultType=int.class,before=true)
	void insertPerson(Person person);
	
	@Update("update person set name=#{name},age=#{age} where id=#{id}")
	void updatePerson(Person person);
	
	@Delete("delete from person where id=#{id}")
	void deletePerson(Integer id);
	
	@Select("select id,name,age,a.addr_id,a.country,a.province,a.city from person p,address a where p.addr_id=a.addr_id and id=#{id}")
	//@Resutl�ķ�ʽ�׶��� Results���ܹ���
	/*@Results({
		@Result(id=true,column="addr_id",property="address.addrId"),
		@Result(column="country",property="address.country"),
		@Result(column="province",property="address.province"),
		@Result(column="city",property="address.city")
	})*/
	//@ResultMapʹ�ý��ӳ����Թ���
	@ResultMap("com.zmc.annotaion.AnnotationMapper.PersonWithAddressResultMap")
	Person findPersonById(Integer id);
	
	//��ʽ��
	@Select("select * from person where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="age",property="age"),
		@Result(column="addr_id",property="address",
				one=@One(select="com.zmc.annotaion.AnnotationMapper.findAllAddrssById"))
		
	})
	Person findPersonById2(Integer id);
	
	@Select("select * from address")
	/*@Results({
		@Result(id=true,column="addr_id",property="addrId"),
		@Result(id=true,column="country",property="country"),
		@Result(id=true,column="province",property="province"),
		@Result(id=true,column="city",property="city")
	})*/
	@ResultMap("com.zmc.annotaion.AnnotationMapper.AddressResultMap")
	List<Address> findAllAddrss();
	
	@Select("select * from address where addr_id=#{id}")
	/*@Results({
		@Result(id=true,column="addr_id",property="addrId"),
		@Result(id=true,column="country",property="country"),
		@Result(id=true,column="province",property="province"),
		@Result(id=true,column="city",property="city")
	})*/
	@ResultMap("com.zmc.annotaion.AnnotationMapper.AddressResultMap")
	List<Address> findAllAddrssById(Integer id);
}
