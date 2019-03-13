package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 多线程门楦
 * @author Administrator
 *
 */
public class Test07 {
	List<Object> list=new ArrayList<Object>();
	
	
	public int getSize(){
		return list.size();
	}
	
	
	public void add(Object o){
		list.add(o);
	}
	
	public static void main(String[] args) {
		final CountDownLatch latch=new CountDownLatch(1);
		
		final Test07 test07=new Test07();
		//线程2
		new Thread(new Runnable(){
			@Override
			public void run() {
			System.out.println(Thread.currentThread().getName()+"启动");
            if(test07.getSize()!=5){
            	try {
					latch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
            	}
            System.out.println(Thread.currentThread().getName()+"结束");
			}
			
		},"t2").start();
		
		
		new Thread(new Runnable(){

			@Override
			public void run() {
			System.out.println(Thread.currentThread().getName()+"启动");
			for(int i=0;i<10;i++){
				test07.add(i);
				System.out.println("add:"+i);
				if(test07.getSize()==5){
					latch.countDown();
				}
			 }
			System.out.println(Thread.currentThread().getName()+"结束");
			}
			
		},"t1").start();
	}

}
