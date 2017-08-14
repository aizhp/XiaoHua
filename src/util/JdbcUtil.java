package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import entity.User;
//数据库连接
public class JdbcUtil {
	
		private static String driverName=null;
		private static String connUrl=null;
		private static String user=null;
		private static String password=null;
		private static Connection conn=null;
		private static ResultSet rs=null;
		private static Statement stm=null;
		static{//静态模块
			try {
				InputStream ips=null;
				ips=JdbcUtil.class.getResourceAsStream("DBConfig.properties");
				Properties prop=new Properties();
				prop.load(ips);
				driverName=prop.getProperty("driverName");
				connUrl=prop.getProperty("connUrl");
				user=prop.getProperty("user");
				password=prop.getProperty("password");
				} catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}
		}		
		//获取数据库连接
			public static Connection getConnection() throws ClassNotFoundException,SQLException{
				Class.forName(driverName);
				conn=DriverManager.getConnection(connUrl,user,password);
				return conn;
				
			}
			//数据查询
			public static ResultSet queryDate(String sql) throws ClassNotFoundException{
				Statement stm=null;
				try {
					conn=getConnection();
					stm=conn.createStatement();
					rs=stm.executeQuery(sql);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				return rs;
			}
				//数据更新
				
				public static boolean Update(String sql) throws ClassNotFoundException{
					int a = 0;
					
					try {
						conn=getConnection();
						stm=conn.createStatement();
						a=stm.executeUpdate(sql);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					finally{
						if(rs!=null){
							try {
								rs.close();
							} catch (Exception e) {
								// TODO: handle exception
								rs = null;
							}
						}
						if(stm!=null){
							try {
								stm.close();
							} catch (Exception e) {
								// TODO: handle exception
								stm=null;
							}
						}
						if(conn!=null){
							try {
								conn.close();
							} catch (Exception e) {
								// TODO: handle exception
								conn= null;
							}
						}
					}
					if(a>0){
						return true;
					}
					else{
						return false;
					}
				}
				//关闭数据库
				public static void closeConnection(){
					if(rs!=null){
						try {
							rs.close();
						} catch (Exception e) {
							// TODO: handle exception
							rs=null;
						}
					}
					if(stm!=null){
						try {
							stm.close();
						} catch (Exception e) {
							// TODO: handle exception
							stm=null;
						}
					}
					if(conn!=null){
						try {
							conn.close();
						} catch (Exception e) {
							// TODO: handle exception
							conn= null;
						}
					
				}
			}
			
			
				
				
				public User queryByName(String name) throws Exception{
					Connection con =null;
					Statement st = null;
					User u = new User();
					try {
						String sql = "select * from stua where name='"+name+"'";
						ResultSet rs=JdbcUtil.queryDate(sql);
						while(rs.next()){
							u.setName(rs.getString(name));
							
						}	
						return u;
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return null;
					}
				}
				
				
		}
