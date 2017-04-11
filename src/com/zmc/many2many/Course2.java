package com.zmc.many2many;

import java.util.List;

public class Course2 {
	private Integer id;
	private String courseCode; // 课程编号
	private String courseName;// 课程名称
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Student2> getStudents() {
		return students;
	}
	public void setStudents(List<Student2> students) {
		this.students = students;
	}
	private List<Student2> students;// 选课学生
	@Override
	public String toString() {
		return "Course2 [id=" + id + ", courseCode=" + courseCode
				+ ", courseName=" + courseName + ", students=" + students + "]";
	}
	
}
