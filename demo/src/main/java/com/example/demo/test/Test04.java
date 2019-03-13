package com.example.demo.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test04 {
	public static void main(String[] args) throws Exception {
		List<String> list=new ArrayList<String>();
		list.add("jjj");
		list.add("kkkk");
		
		
		Class listClass=list.getClass();
		Method method=listClass.getMethod("add",Object.class);
		method.invoke(list,100);
		
		for(Object object:list){
			System.out.println(object);
		}
	}

}
