package com.example.demo.test;

import java.lang.reflect.Method;

/**
 * 反射调用method
 * @author Administrator
 *
 */

public class Test03 {
	public static void main(String[] args) throws Exception {
		
		Class cla=Class.forName("com.example.demo.test.Student");
		Method[] meths=cla.getMethods();
		for(Method method:meths){
			//System.out.println(method);
		}
		Method method=cla.getDeclaredMethod("Show2");
		Student student=(Student)cla.getConstructor().newInstance();
		method.invoke(student);
		
		
	}

}
