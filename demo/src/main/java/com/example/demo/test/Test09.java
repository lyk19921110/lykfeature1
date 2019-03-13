package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;


/**
 * 生产者以及消费者，工厂模式?2个生产者,10个消费者
 * @author Administrator
 *
 */

public class Test09 {
	
	//容器仓库
	volatile  List<Object> list=new ArrayList<Object>();
	
	//获取库存
	int getSize(){
		return list.size();
	}
	
	//生产一个
	void push(Object o){
		list.add(o);
	}
	
	//消费一个
	void getOne(){
		list.remove(0);
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		final Test09 test09=new Test09();
		
		final Object o=new Object();
		
		
		 //2个生产者
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					synchronized(o){
						while(test09.getSize()>=10){
							try {
								o.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println(Thread.currentThread().getName()+"开始等待");
						}
						try {
							Thread.currentThread().sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						while(test09.getSize()<10){
							test09.push(test09.getSize()+1);
							System.out.println(Thread.currentThread().getName()+":生产1个,库存为:"+test09.getSize());
						}
						o.notifyAll();
					}
					
				}
				
			},"生产者:"+i).start();
		}
		
		
		
		//10个消费者
		for(int i=0;i<10;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					synchronized(o){
						while(test09.getSize()>0){
							test09.getOne();
							System.out.println(Thread.currentThread().getName()+":消费1个,库存为:"+test09.getSize());
							
						}
						try {
							Thread.currentThread().sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						while(test09.getSize()<=0){
							try {
								System.out.println(Thread.currentThread().getName()+"开始等待");
								o.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						o.notifyAll();
					}
					
				}
				
			},"消费者"+i).start();
		}
		
		
		
		       
				
		
	}
	
	
	

}
