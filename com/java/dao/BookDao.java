package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.java.ubook.Book;
import com.java.util.ConnectionFactory;

/**
 * 在JDBC开发领域，有一个DAO（data access object 数据访问对象）
 * 我们会将tb_book表的所有操作
 * 数据的基本操作增删改查 ，封装到一个BookDao类当中
 **/
public class BookDao {
	
	Connection con=null;
	PreparedStatement pstm=null;
	ResultSet rs = null;

	/*
	 * 根据id查询对应的书籍信息
	 */
	public Book queryById(Integer id) {
		try {
			// 通过连接工厂获得连接对象
			con = ConnectionFactory.getConnection();
			String sql = " select * from tb_book where id = ? ";
			System.out.println(sql);
			//获得发送sql语句的对象PreparedStatement
			pstm=con.prepareStatement(sql);
			pstm.setObject(1, id);
			//执行查询
			rs=pstm.executeQuery();
			//处理返回的结果集
			if(rs.next()) {
				// 创建一个Book对象保存查到的每一条数据
				Book book = new Book();
				// 获取查询的数据的每一列的值
				String name = rs.getString("name");
				String author = rs.getString("author");
				Date publicationdate = rs.getDate("publicationdate");
				String publication = rs.getString("publication");
				Double price = rs.getDouble("price");
				String image = rs.getString("image");
				String remark = rs.getString("remark");
				// 保存到Book对象
				book.setId(id);
				book.setName(name);
				book.setAuthor(author);
				book.setPublicationdate(publicationdate);
				book.setPublication(publication);
				book.setPrice(price);
				book.setImage(image);
				book.setRemark(remark);
				// 调试打印，控制台输出
				System.out.println(book);
				// 将Book对象保存到List集合
				return book;
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			// 在try/catch时使用，finally里面的代码一定会被执行，保证一定会被执行的代码通常放到这里
			// 6. 关闭连接
			ConnectionFactory.close(con, pstm, rs);
		}			
	}
	
	/*
	 * 查询所有图书数据
	 * @return 包含所有图书数据的Book对象的集合
	 */
	public ArrayList<Book> queryAll(){
		//创建一个集合保存Book
		ArrayList<Book> list=new ArrayList<>();
		
		try {
			// 通过连接工厂获取连接对象
			con = ConnectionFactory.getConnection();
			String sql = " select * from tb_book ";
			System.out.println(sql);
			// 获得发送sql语句的对象PreparedStatement
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				// 创建一个Book对象保存查到的每一条数据
				Book book = new Book();
				// 获得查询的数据的每一列的值
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				Date publicationdate = rs.getDate("publicationdate");
				String publication = rs.getString("publication");
				Double price = rs.getDouble("price");
				String image = rs.getString("image");
				String remark = rs.getString("remark");
				
				book.setId(id);
				book.setName(name);
				book.setAuthor(author);
				book.setPublicationdate(publicationdate);
				book.setPublication(publication);
				book.setPrice(price);
				book.setImage(image);
				book.setRemark(remark);
				
				System.out.println(book);
				// 将Book对象保存到List集合
				list.add(book);
			}
			// 将集合返回给调用者
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			// 6. 关闭连接
			ConnectionFactory.close(con, pstm, rs);
		}
		
	}

}
