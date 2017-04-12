package com.zmc.onetomany;

import java.util.List;

import com.zmc.many2many.Course2;

public interface One2ManyMapper {
	Tutor findTutorById(Integer tutorid);
	List<Course2> findCoursesByTutor(Integer id);
}
