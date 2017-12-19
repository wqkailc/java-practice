package com.java.ubook;

/**
 * 书本信息类，
 */

import java.util.Date;

public class Book {
	private Integer id;  
	private String name;  
	private String author; 
	private Date publicationdate; 
	private String publication; 
	private Double price; 
	private String image; 
	private String remark;
	
	// 构造器
    public Book() {
	    super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublicationdate() {
		return publicationdate;
	}
	public void setPublicationdate(Date publicationdate) {
		this.publicationdate = publicationdate;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	} 
	
	//改写该类的toString()方法，便以调试
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author+ 
				", publicationdate=" + publicationdate+ 
				", publication=" + publication + ", price=" + price +
				", image=" + image + ", remark=" + remark + "]";
	}

}
