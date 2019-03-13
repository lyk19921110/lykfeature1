package com.example.demo.test;


public class Test05 {

	public static void main(String[] args) {
		
		LykInterface s=(LykInterface) new TestProxy().getProxyObject(new LykInterfaceImpl());
		s.eat();
		s.say();
	}

}
