package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 数据库工具类
 * 连接工厂，封装获取连接和关闭连接的操作
 * 面向对象封装功能
 */
public class ConnectionFactory {
	//mysql数据库驱动接口
	private static final String DRIVER="com.mysql.jdbc.Driver";
	//用于进行数据库连接的URL
	private static final String URL="jdbc：mysql://127.0.0.1:3306/jsj152";
	//数据库用户名默认为root
	private static final String USER="root";
	//连接数据库所用的密码
	private static final String PASSWORD="123456";
	//工具类与数据连接
	private static Connection connection;
	

	public static Connection getConnection() {
		//成功返回连接对象
		return connection; 
	}
	
	//静态快优先执行，为connection变量赋值
	static {
		try {
			// 注册驱动
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}

	/**
	 * 关闭数据库资源
	 * */
	public static void close(Connection con,PreparedStatement pstm,ResultSet rs){
		
		try {
			if(rs != null) 
				rs.close();
			
			if(pstm != null) 
				pstm.close();
			
			if(con != null)
				con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
