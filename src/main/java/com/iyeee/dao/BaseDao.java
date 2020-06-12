package com.iyeee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iyeee.util.DbUtil;

/**
 * 
 * @author llq
 *����dao����װ��������
 */
public class BaseDao {
	private DbUtil dbUtil = new DbUtil();
	
	/**
	 * �ر����ݿ����ӣ��ͷ���Դ
	 */
	public void closeCon(){
		dbUtil.closeCon();
	}
	
	/**
	 * ������ѯ,������ѯ
	 */
	public ResultSet query(String sql){
		try {
			PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			return prepareStatement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	/**
	 *�ı����ݿ����ݲ���
	 */
	public boolean update(String sql){
		try {
			return dbUtil.getConnection().prepareStatement(sql).executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public Connection getConnection(){
		return dbUtil.getConnection();
	}
}