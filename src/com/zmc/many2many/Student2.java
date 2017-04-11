package com.zmc.many2many;

import java.util.List;

import com.zmc.onetomany.Course;

public class Student2 {
	private Integer id;
	private String name; // 姓名
	private String gender; // 性别
	private String major; // 专业
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public Student2() {
	}
	
	public List<Course2> getCourses() {
		return courses;
	}
	public void setCourses(List<Course2> courses) {
		this.courses = courses;
	}

	private String grade; // 年级
	private List<Course2> courses;// 所选的课程
	@Override
	public String toString() {
		return "Student2 [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", major=" + major + ", grade=" + grade + ", courses="
				+ courses + "]";
	}
	
}
