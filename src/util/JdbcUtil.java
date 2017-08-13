package util;

import java.sql.*;
//数据库连接
public class JdbcUtil {
	public static Connection getConnection()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/wfx";
		String user="root";
		String password="root";
		Connection con=DriverManager.getConnection(url,user,password);
		
		return con;
	}
}
