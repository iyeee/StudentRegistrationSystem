package com.iyeee.model;

/**
 * ϵͳ��ʼ����һЩ��Ϣ
 * @author bojiangzhou
 *
 */
public class SystemInfo {
	
	private int id; 
	
	private String schoolName; //ѧУ����
	
	private int forbidTeacher; //��ֹ��ʦ��¼ϵͳ
	
	private int forbidStudent; //��ֹѧ����¼ϵͳ
	
	private String noticeTeacher; //��ʦ֪ͨ
	
	private String noticeStudent; //ѧ��֪ͨ

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getForbidTeacher() {
		return forbidTeacher;
	}

	public void setForbidTeacher(int forbidTeacher) {
		this.forbidTeacher = forbidTeacher;
	}

	public int getForbidStudent() {
		return forbidStudent;
	}

	public void setForbidStudent(int forbidStudent) {
		this.forbidStudent = forbidStudent;
	}

	public String getNoticeTeacher() {
		return noticeTeacher;
	}

	public void setNoticeTeacher(String noticeTeacher) {
		this.noticeTeacher = noticeTeacher;
	}

	public String getNoticeStudent() {
		return noticeStudent;
	}

	public void setNoticeStudent(String noticeStudent) {
		this.noticeStudent = noticeStudent;
	}
	
}
