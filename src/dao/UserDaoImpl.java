package dao;

import java.beans.Statement;
import java.sql.Connection;

import util.JdbcUtil;

import java.sql.*;

import entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	//删除实现
	public void deleteByName(String name) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st = null;
		try {
			con=JdbcUtil.getConnection();
			st=con.createStatement();
			String sql="delete from user where name='"+name+"'";
			st.execute(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
