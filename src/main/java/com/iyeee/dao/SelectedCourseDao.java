package com.iyeee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iyeee.model.Page;
import com.iyeee.model.SelectedCourse;
import org.junit.Test;

/**
 * 
 * @author llq
 *选课表数据库操作封装
 */
public class SelectedCourseDao extends BaseDao {
	public List<SelectedCourse> getSelectedCourseList(SelectedCourse selectedCourse, Page page){
		System.out.println("getSelectCourseList");
		List<SelectedCourse> ret = new ArrayList<SelectedCourse>();
		String sql = "select * from s_selected_course ";
		if(selectedCourse.getStudentId() != 0){
			sql += " and student_id = " + selectedCourse.getStudentId();
		}
		if(selectedCourse.getCourseId() != 0){
			sql += " and course_id = " + selectedCourse.getCourseId();
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		sql = sql.replaceFirst("and", "where");
		ResultSet resultSet = query(sql);
		try {
			while(resultSet.next()){
				SelectedCourse cl = new SelectedCourse();
				cl.setId(resultSet.getInt("id"));
				cl.setCourseId(resultSet.getInt("course_id"));
				cl.setStudentId(resultSet.getInt("student_id"));
				cl.setType(resultSet.getString("type"));
				ret.add(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public int getSelectedCourseListTotal(SelectedCourse selectedCourse){
		System.out.println("getSelectedCourseListTotal(SelectedCourse selectedCourse)");
		int total = 0;
		String sql = "select count(*)as total from s_selected_course ";
		if(selectedCourse.getStudentId() != 0){
			sql += " and student_id = " + selectedCourse.getStudentId();
		}
		if(selectedCourse.getCourseId() != 0){
			sql += " and course_id = " + selectedCourse.getCourseId();
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
	/**
	 * 检查学生是否已经选择该门课程
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	public boolean isSelected(int studentId,int courseId){
		System.out.println("isSelected");
		boolean ret = false;
		String sql = "select * from s_selected_course where student_id = " + studentId + " and course_id = " + courseId;
		ResultSet query = query(sql);
		try {
			if(query.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * 添加选课信息
	 * @param selectedCourse
	 * @return
	 */
	public boolean addSelectedCourse(SelectedCourse selectedCourse){
		String sql = "insert into s_selected_course values(null,"+selectedCourse.getStudentId()+","+selectedCourse.getCourseId()+",\""+selectedCourse.getType()+"\")";
		return update(sql);
	}
	/**
	 * 删除所选课程
	 * @param id
	 * @return
	 */
	public boolean deleteSelectedCourse(int id){
		String sql = "delete from s_selected_course where id = " + id;
		return update(sql);
	}
	public int getMainCost(int id){
		String sql="select sum(cost) as total from s_course,s_selected_course where s_course.id=s_selected_course.course_id and s_selected_course.type= '" +"主选"+

				"' group by student_id " +
				"having student_id="+id;
		ResultSet query = query(sql);
		int total=0;
		try {
			while (query.next()) {
				total = query.getInt("total");
			}
			} catch(SQLException e){
				e.printStackTrace();
			}

		return total;

	}
	public int getTotalCost(int id){
		String sql="select sum(cost) as total from s_course,s_selected_course where s_course.id=s_selected_course.course_id" +

				" group by student_id " +
				"having student_id="+id;
		ResultSet query = query(sql);
		int total=0;
		try {
			while (query.next()) {
				total = query.getInt("total");
			}
		} catch(SQLException e){
			e.printStackTrace();
		}

		return total;

	}
	@Test
	public void testGetMain(){
//		System.out.println(getMainCost(2));
		System.out.println(getTotalCost(2));
	}
	/**
	 * 获取一条选课数据
	 * @param id
	 * @return
	 */
	public SelectedCourse getSelectedCourse(int id){
		System.out.println("getSelectCourse");
		SelectedCourse ret = null;
		String sql = "select * from s_selected_course where id = " + id;
		ResultSet query = query(sql);
		try {
			if(query.next()){
				ret = new SelectedCourse();
				ret.setId(query.getInt("id"));
				ret.setCourseId(query.getInt("course_id"));
				ret.setStudentId(query.getInt("student_id"));
				ret.setType(query.getString("type"));
				return ret;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	@Test
	public void Test(){
		deleteSelectedCourse(6);
	}
	@Test
	public void Test2(){
		SelectedCourse selectedCourse = getSelectedCourse(6);
		System.out.println(selectedCourse.getType());
	}
	@Test
	public void Test3(){
		SelectedCourse selectedCourse=new SelectedCourse();
		selectedCourse.setStudentId(1);
		selectedCourse.setCourseId(14);
		selectedCourse.setType("主选");
		addSelectedCourse(selectedCourse);
	}
}
