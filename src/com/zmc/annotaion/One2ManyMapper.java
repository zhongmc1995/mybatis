package com.zmc.annotaion;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zmc.onetomany.Tutor;


/**
 * @author zhongmc
 *	一对多注解测试
 */
public interface One2ManyMapper {
	
	@Select("select * from tutors where tutor_id=#{id}")
	@Results({
		@Result(property="tutorId",column="tutor_id"),
		@Result(property="address",column="adds_id",
		one=@One(select="com.zmc.annotaion.AnnotationMapper.findAllAddrssById")),
		@Result(property="courses",column="tutor_id",
		many=@Many(select="com.zmc.onetomany.One2ManyMapper.findCoursesByTutor"))
	})
	Tutor findTutorByTutorId(Integer id);
}
