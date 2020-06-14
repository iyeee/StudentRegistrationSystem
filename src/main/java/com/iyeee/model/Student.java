package com.iyeee.model;

import java.io.InputStream;

/**
 * 
 * @author llq
 *学生实体类
 */
public class Student {
	private int id;
	private String sn;
	private int num;
	private String name;
	private String password;
	private int grade;
	private int clazzId;
	private String status;
	private String sex;
	private String identity;
	private String graduateDate;
	private String birthday;
	private String mobile;
	private String qq;
	private InputStream photo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClazzId() {
		return clazzId;
	}

	public void setClazzId(int clazzId) {
		this.clazzId = clazzId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getidentity() {
		return identity;
	}

	public void setidentity(String identity) {
		this.identity = identity;
	}

	public String getGraduateDate() {
		return graduateDate;
	}

	public void setGraduateDate(String graduateDate) {
		this.graduateDate = graduateDate;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public InputStream getPhoto() {
		return photo;
	}

	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", sn='" + sn + '\'' +
				", num=" + num +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", grade=" + grade +
				", clazzId=" + clazzId +
				", status='" + status + '\'' +
				", sex='" + sex + '\'' +
				", identity='" + identity + '\'' +
				", graduateDate=" + graduateDate +
				", birthday=" + birthday +
				", mobile='" + mobile + '\'' +
				", qq='" + qq + '\'' +
				", photo=" + photo +
				'}';
	}
}
