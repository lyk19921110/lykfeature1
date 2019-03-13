package com.example.demo.test;

import java.lang.reflect.Constructor;

import org.mockito.internal.util.reflection.Constructors;


/**
 * 反射调用构造方法
 * @author Administrator
 *
 */
public class Test01 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		Class cla=Class.forName("com.example.demo.test.Student");
		
		Constructor ct=cla.getDeclaredConstructor(String.class);
		Student  student=(Student) ct.newInstance("张三");
		
		
		Constructor ct2=cla.getDeclaredConstructor(String.class,int.class);
		Student student2=(Student) ct2.newInstance("李四",28);
		
		Constructor[] cos=cla.getConstructors();
		for(Constructor co:cos){
			System.out.println(co);
		}
	}

}
