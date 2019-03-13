package com.example.demo.test;

import java.lang.reflect.Field;

/**
 * 反射调用变量
 * @author Administrator
 *
 */

public class Test02 {
	
	public static void main(String[] args) throws Exception {
		Class cla=Class.forName("com.example.demo.test.Student");
		Field[] fiels=cla.getFields();
		for(Field fiel:fiels){
			//System.out.println(fiel);
			
		}
		
		Object obj=cla.newInstance();
		
		Field file=cla.getDeclaredField("name");
		file.setAccessible(true);
		file.set(obj, "张三");
		
		Field file2=cla.getDeclaredField("size");
		file2.set(obj,"188");
		
		Student stu=(Student)obj;
		System.out.println(stu.toString());
	}

}
