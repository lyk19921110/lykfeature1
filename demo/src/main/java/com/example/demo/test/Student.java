package com.example.demo.test;

public class Student {
	
	private String name;
	private int age;
	public String address;
	protected String size;
	
	
	public void Show1(){
		System.out.println("public修饰的方法");
	}
	
	
	protected void Show2(){
		System.out.println("protected修饰方法");
	}
	
	
	private void Show3(){
		System.out.println("private修饰的方法");
	}
	
	
	
	



	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + ", size=" + size + "]";
	}



	public Student() {
		super();
		System.out.println("无参构造");
	}
	
	
	
	public Student(String name) {
		super();
		this.name = name;
		System.out.println("一个参数:"+name);
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("两个参数:"+name+age);
	}
	
	

}
