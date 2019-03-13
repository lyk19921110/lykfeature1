package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 多线程
 * @author Administrator
 *
 */

public class Test06 {
	
	List<Object> list=new ArrayList<Object>();
	
	
	public void add(Object object){
		list.add(object);
	}
	
	
	public int getSize(){
		return list.size();
	}
	
	public static void main(String[] args) {
		 //CountDownLatch latch=new CountDownLatch(1);
		 final Test06  test06=new Test06();
		 final Object o=new Object();
		 
		 new Thread(new Runnable(){
			@Override
			public void run() {
				//线程2启动
				System.out.println(Thread.currentThread().getName()+"启动");
				synchronized(o){
					try {
						if(test06.getSize()!=5){
							o.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"结束");
					o.notify();
				}
			}
			 
		 },"t2").start();
		 
		 //启动线程1
		 new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"启动");
				synchronized(o){
					for(int i=0;i<10;i++){
						
						test06.add(i);
						System.out.println("add:"+i);
						
						if(test06.getSize()==5){
							try {
								o.notify();
								o.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
					}
				}
				System.out.println(Thread.currentThread().getName()+"结束");
			}
		 },"t1").start();
	}

}
