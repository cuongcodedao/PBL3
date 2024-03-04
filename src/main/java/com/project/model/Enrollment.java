package com.project.model;

import java.sql.Date;

public class Enrollment {
	private int id;
	private int id_user;
	private int id_course;
	private int progress;
	private Date time_enroll;
	private String infor;
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
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public Date getTime_enroll() {
		return time_enroll;
	}
	public void setTime_enroll(Date time_enroll) {
		this.time_enroll = time_enroll;
	}
	public String getInfor() {
		return infor;
	}
	public void setInfor(String infor) {
		this.infor = infor;
	}
	
	
}
