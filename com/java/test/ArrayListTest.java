package com.java.test;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		/**
		 * ArrayList是最常用的集合(盒子),集合可以理解成数组的扩展，用来存储多个数据
		 * 1. 集合没有长度，可以无限存储
		 * 2. 集合可以存储任何类型的数据
		 * */
		// 创建集合
		ArrayList list = new ArrayList();
		// 存储数据  add
		list.add("fkjava");  // 0 
		list.add("hello");  // 1
		list.add(100);     // 2
		// 从集合中取数据 get(下标)
		Object obj = list.get(0);
		System.out.println(obj);
		
		String obj1 = (String)list.get(1);
		System.out.println(obj1);
		
		Integer obj2 = (Integer)list.get(2);
		System.out.println(obj2);
		
		// size()返回list集合的存储数据的大小
		System.out.println(list.size());
		
		// 遍历
		for(int i = 0;i < list.size();i++){
			System.out.println(list.get(i));
		}

	}

}
