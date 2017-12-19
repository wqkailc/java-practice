package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.ubook.User;
import com.java.util.ConnectionFactory;

/**
 * 在JDBC开发领域，有一个DAO（data access object 数据访问对象）
 * 我们会将tb_user表的所有操作
 * 数据的基本操作增删改查 ，封装到一个UserDao类当中
 **/
public class UserDao {
	
	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	/**
	 * 注册界面 
	 * User @return boolean 成功返回true，失败返回false
	 * */
	public boolean register(User user){
		try {
			con = ConnectionFactory.getConnection();
			String sql = "insert into tb_user(loginname,password,username,sex,email,phone,address) values(?,?,?,?,?,?,?)";
			System.out.println(sql);
			pstm = con.prepareStatement(sql);
			pstm.setObject(1, user.getLoginname());
			pstm.setObject(2, user.getPassword());
			pstm.setObject(3, user.getUsername());
			pstm.setObject(4, user.getSex());
			pstm.setObject(5, user.getEmail());
			pstm.setObject(6, user.getPhone());
			pstm.setObject(7, user.getAddress());
			
			int result = pstm.executeUpdate();
			
			if(result > 0) 
				return true;
			else
				return false;
			
		} catch (Exception e) {
			System.out.println("异常处理");
			e.printStackTrace();
			return false;
		}finally{
			ConnectionFactory.close(con, pstm, null);
		}
	}
	
	/**
	 * 登录方法
	 * @param loginname
	 * @param password
	 * @return 如果用户存在，返回包含用户信息的User对象
	 * 如果用户不存在，返回null
	 * */
	public User login(String loginname,String password){

		try {
			// 通过连接工厂获取连接对象
			con = ConnectionFactory.getConnection();
			String sql = "select * from tb_user where loginname = ? and password = ? ";
			System.out.println(sql);
			pstm = con.prepareStatement(sql);
			// 设置参数
			pstm.setObject(1, loginname);
			pstm.setObject(2, password);
			// 执行sql 执行查询语句，去数据库（外存）查找数据，找到后将数据放到内存（ResultSet），返回结果集  
			rs = pstm.executeQuery();
			// 处理结果集
			if(rs.next()){
				// 获得查询到的数据
				Integer id = rs.getInt("id");
				// 创建一个User对象
				User user = new User();
				user.setId(id);
				user.setUsername(rs.getString("username"));
				user.setAddress(rs.getString("address"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setLoginname(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			ConnectionFactory.close(con, pstm, rs);
		}
	}

}
