package com.example.demo.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk1.7自带的动态代理
 * @author Administrator
 *
 */

public class TestProxy implements InvocationHandler {
	
	/**
	 * 被代理的对象
	 */
	Object tartgetObject; 
	
	/**
	 * 获取被代理的对象
	 * @param object
	 * @return
	 */
	public Object getProxyObject(Object object){
		this.tartgetObject=object;
		return Proxy.newProxyInstance(tartgetObject.getClass().getClassLoader(),
				tartgetObject.getClass().getInterfaces(), this);
	}
	
	/**
	 * 代理对象的方法执行都通过下面的方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始........");
		//执行相应的方法
		method.invoke(tartgetObject, args);
		System.out.println("结束........");
		return null;
	}

}
