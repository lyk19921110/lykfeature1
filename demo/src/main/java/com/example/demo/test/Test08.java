package com.example.demo.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * reentrantLock锁
 * @author Administrator
 *
 */
public class Test08 {
	
	
	
	
	/*void m1(){
		lock.lock();
		for(int i=0;i<10;i++){
			System.out.println("m1"+i);
		}
		//lock.unlock();
		
	}
	
	void m2(){
		lock.lock();
		for(int i=0;i<10;i++){
			System.out.println("m2"+i);
		}
		lock.unlock();
	}*/

	
	public static void main(String[] args) {
		final Lock lock=new ReentrantLock();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				lock.lock();
				for(int i=0;i<200;i++){
					System.out.println("m1:"+i);
				} 
				lock.unlock();
			}
			
		},"t1").start();
		
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				lock.lock();
				for(int i=0;i<200;i++){
					System.out.println("m2:"+i);
				}
				lock.unlock();
			}
			
		},"t2").start();
	}
	
	
	

}
