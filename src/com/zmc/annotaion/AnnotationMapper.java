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
	 * 自动生成主键

		可以使用 @Options注解的userGeneratedKeys和keyProperty属性让数据库产生 auto_increment（自增长）列的值，然后将生成的值设置到输入参数对象的属性中。

		@Insert("insert into students(name,email,addr_id, phone) 
				values(#{name},#{email},#{address.addr Id},#{phone})") 
		@Options(useGeneratedKeys = true, keyProperty = "studId") 
		int insertStudent(Student student); 

		这里STUD_ID列值将会通过MySQL数据库自动生成。并且生成的值将会被设置到student对象的studId属性中。
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class); 
		mapper.insertStudent(student); 
		int studentId = student.getStudId(); 
		
		有一些数据库如Oracle，并不支持AUTO_INCREMENT列属性，它使用序列（SEQUENCE）来产生主键的值。
		我们可以使用 @SelectKey注解来为任意SQL语句来指定主键值，作为主键列的值。假设我们有一个名为STUD_ID_SEQ的序列来生成STUD_ID主键值。
		 
		@Insert("insert into students(stud_id,name,email,addr_id,phone) values(#{studId},#{name},#{email},#{address.addrId},#{phone})") 
		@SelectKey(statement="select my_seq.nextval from dual",  
		keyProperty="studId", resultType=int.class, before=true) 
		int insertStudent(Student student); 

		这里我们使用了 @SelectKey来生成主键值，并且存储到了student对象的studId属性上。由于我们设置了before=true,该语句将会在执行INSERT语句之前执行.

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
	//@Resutl的方式弊端是 Results不能共用
	/*@Results({
		@Result(id=true,column="addr_id",property="address.addrId"),
		@Result(column="country",property="address.country"),
		@Result(column="province",property="address.province"),
		@Result(column="city",property="address.city")
	})*/
	//@ResultMap使得结果映射可以共用
	@ResultMap("com.zmc.annotaion.AnnotationMapper.PersonWithAddressResultMap")
	Person findPersonById(Integer id);
	
	//方式二
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
