package com.iyeee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iyeee.model.Page;
import com.iyeee.model.Teacher;
import com.iyeee.util.StringUtil;
import org.junit.Test;

/**
 * 
 * @author llq
 *教师表数据库操作
 */
public class TeacherDao extends BaseDao {
	public boolean addTeacher(Teacher teacher){
		String sql = "insert into s_teacher values(null,null,'"+teacher.getSn()+"','"+teacher.getName()+"'";
		sql += ",'" + teacher.getPassword() + "','" + teacher.getClazzId();
		sql += "','" + teacher.getSex() +"','"+teacher.getidentity();
		sql += "','" + teacher.getStatus();
		sql +="','" + teacher.getDepartment();
		sql	+= "','" + teacher.getMobile() + "'";
		sql += ",'" + teacher.getQq() + "',null)";
		return update(sql);
	}
	@Test
	public void testAddTeacher(){
		Teacher teacher = new Teacher();
		teacher.setSn("S21322123123");
		teacher.setName("大明");
		teacher.setPassword("12321");
		teacher.setidentity("12323122");
		teacher.setSex("男");
		teacher.setClazzId(1);
		teacher.setStatus("校长");
		teacher.setDepartment("计算机科学与技术");
		teacher.setMobile("13767676767");
		teacher.setQq("123231233");
		addTeacher(teacher);
	}
	public boolean editTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql = "update s_teacher set name = '"+teacher.getName()+"'";
		sql += ",sex = '" + teacher.getSex() + "'";
		sql += ",mobile = '" + teacher.getMobile() + "'";
		sql += ",qq = '" + teacher.getQq() + "'";
		sql += ",clazz_id = '" + teacher.getClazzId()+"'";
		sql += ",num='"+ teacher.getNum()+"'";
		sql += ",identity='"+teacher.getidentity()+"'";
		sql += ",status='"+teacher.getStatus()+"'";
		sql += ",department='"+teacher.getDepartment();
		sql += "' where id = " + teacher.getId();
		return update(sql);
	}
	@Test
	public void testEditTeacher(){
		Teacher teacher = new Teacher();
		teacher.setId(9);
		teacher.setSn("S21322123123");
		teacher.setName("大明");
		teacher.setPassword("12321");
		teacher.setidentity("12323122");
		teacher.setSex("男");
		teacher.setClazzId(1);
		teacher.setStatus("校长");
		teacher.setDepartment("软件学院");
		teacher.setMobile("13767676767");
		teacher.setQq("123231233");
		editTeacher(teacher);

	}
	public boolean setTeacherPhoto(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql = "update s_teacher set photo = ? where id = ?";
		Connection connection = getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setBinaryStream(1, teacher.getPhoto());
			prepareStatement.setInt(2, teacher.getId());
			return prepareStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update(sql);
	}
	public boolean deleteTeacher(String ids) {
		// TODO Auto-generated method stub
		String sql = "delete from s_teacher where id in("+ids+")";
		return update(sql);
	}
	public Teacher getTeacher(int id){
		String sql = "select * from s_teacher where id = " + id;
		Teacher teacher = null;
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setClazzId(resultSet.getInt("clazz_id"));
				teacher.setMobile(resultSet.getString("mobile"));
				teacher.setName(resultSet.getString("name"));
				teacher.setPassword(resultSet.getString("password"));
				teacher.setPhoto(resultSet.getBinaryStream("photo"));
				teacher.setQq(resultSet.getString("qq"));
				teacher.setSex(resultSet.getString("sex"));
				teacher.setSn(resultSet.getString("sn"));
				teacher.setNum(resultSet.getInt("num"));
				teacher.setidentity(resultSet.getString("identity"));
				teacher.setStatus("status");
				teacher.setDepartment("department");


				return teacher;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}
	public List<Teacher> getTeacherList(Teacher teacher, Page page){
		List<Teacher> ret = new ArrayList<Teacher>();
		String sql = "select * from s_teacher ";
		if(!StringUtil.isEmpty(teacher.getName())){
			sql += "and name like '%" + teacher.getName() + "%'";
		}
		if(teacher.getClazzId() != 0){
			sql += " and clazz_id = " + teacher.getClazzId();
		}
		if(teacher.getId() !=0 ){
			sql += " and id = " + teacher.getId();
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ResultSet resultSet = query(sql.replaceFirst("and", "where"));
		try {
			while(resultSet.next()){
				Teacher t = new Teacher();
				t.setId(resultSet.getInt("id"));
				t.setClazzId(resultSet.getInt("clazz_id"));
				t.setMobile(resultSet.getString("mobile"));
				t.setName(resultSet.getString("name"));
				t.setPassword(resultSet.getString("password"));
				t.setPhoto(resultSet.getBinaryStream("photo"));
				t.setQq(resultSet.getString("qq"));
				t.setSex(resultSet.getString("sex"));
				t.setSn(resultSet.getString("sn"));
				t.setidentity(resultSet.getString("identity"));
				t.setStatus(resultSet.getString("status"));
				t.setDepartment(resultSet.getString("department"));
				ret.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public int getTeacherListTotal(Teacher teacher){
		int total = 0;
		String sql = "select count(*)as total from s_teacher ";
		if(!StringUtil.isEmpty(teacher.getName())){
			sql += "and name like '%" + teacher.getName() + "%'";
		}
		if(teacher.getClazzId() != 0){
			sql += " and clazz_id = " + teacher.getClazzId();
		}
		if(teacher.getId() !=0 ){
			sql += " and id = " + teacher.getId();
		}
		ResultSet resultSet = query(sql.replaceFirst("and", "where"));
		try {
			while(resultSet.next()){
				total = resultSet.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	public Teacher login(String name ,String password){
		String sql = "select * from s_teacher where name = '" + name + "' and password = '" + password + "'";
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setPassword(resultSet.getString("password"));
				teacher.setClazzId(resultSet.getInt("clazz_id"));
				teacher.setMobile(resultSet.getString("mobile"));
				teacher.setPhoto(resultSet.getBinaryStream("photo"));
				teacher.setQq(resultSet.getString("qq"));
				teacher.setSex(resultSet.getString("sex"));
				teacher.setSn(resultSet.getString("sn"));
				teacher.setDepartment(resultSet.getString("department"));
				teacher.setStatus(resultSet.getString("status"));
				teacher.setidentity(resultSet.getString("identity"));

				return teacher;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean editPassword(Teacher teacher,String newPassword) {
		// TODO Auto-generated method stub
		String sql = "update s_teacher set password = '"+newPassword+"' where id = " + teacher.getId();
		return update(sql);
	}
}
