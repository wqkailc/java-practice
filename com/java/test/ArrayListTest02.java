package com.java.test;

import java.util.ArrayList;

public class ArrayListTest02 {

	public static void main(String[] args) {
		/**
		 * ArrayList是最常用的集合(盒子),集合可以理解成数组的扩展，用来存储多个数据
		 * */
		// 创建集合 <String>泛型  表示该集合只能存储String类型的数据
		ArrayList<String> list = new ArrayList<>();
		// 存储数据  add
		list.add("fkjava");  // 0 
		list.add("hello");  // 1
		// list.add(100);     // 2
		
		// 取值（强转）
		/*String obj1 = (String)list.get(1);
		System.out.println(obj1);*/
		
		// 泛型不需要强转
		String obj = list.get(0);
		System.out.println(obj);
		
		// size()返回list集合的存储数据的大小
		System.out.println(list.size());
		
		// 遍历
		/*for(int i = 0;i < list.size();i++){
		 	String s = list.get(i);
			System.out.println(s);
		}*/
		
		// 泛型遍历
		for(String s : list){
			System.out.println(s);
		}

	}

}
