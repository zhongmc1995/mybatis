package com.zmc.onetomany;

import java.util.Date;
import java.util.List;

import com.zmc.many2many.Student2;

public class Course{
	private Integer courseId; 
	private String name; 
	private String description; 
	private Date startDate; 
	private Date endDate;
	private List<Student2> student2s;
	public List<Student2> getStudent2s() {
		return student2s;
	}
	public void setStudent2s(List<Student2> student2s) {
		this.student2s = student2s;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name
				+ ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", student2s=" + student2s + "]";
	} 

}