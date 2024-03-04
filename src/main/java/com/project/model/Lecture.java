package com.project.model;

public class Lecture {
	private int id;
	private int id_lesson;
	private String content;
	private boolean isvid;
	private boolean ispic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_lesson() {
		return id_lesson;
	}
	public void setId_lesson(int id_lesson) {
		this.id_lesson = id_lesson;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isIsvid() {
		return isvid;
	}
	public void setIsvid(boolean isvid) {
		this.isvid = isvid;
	}
	public boolean isIspic() {
		return ispic;
	}
	public void setIspic(boolean ispic) {
		this.ispic = ispic;
	}
	
}
