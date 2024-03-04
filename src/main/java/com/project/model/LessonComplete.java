package com.project.model;

import java.sql.Date;

public class LessonComplete {
	private int id;
	private int id_user;
	private int id_course;
	private int id_lesson;
	private Date timecpl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_course() {
		return id_course;
	}
	public void setId_course(int id_course) {
		this.id_course = id_course;
	}
	public int getId_lesson() {
		return id_lesson;
	}
	public void setId_lesson(int id_lesson) {
		this.id_lesson = id_lesson;
	}
	public Date getTimecpl() {
		return timecpl;
	}
	public void setTimecpl(Date timecpl) {
		this.timecpl = timecpl;
	}
	
	
}
