package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock模式
 * @author Administrator
 *
 */
public class Test10 {
	
	private Lock lock=new ReentrantLock();
	
	private List<Object> list=new ArrayList<Object>();
	
	
	private Condition produce=lock.newCondition();
	
	private Condition consumer=lock.newCondition();
	
	void addOne(Object o){
		list.add(o);
	}
	
	void getOne(){
		list.remove(0);
	}
	
	int getListSize(){
		return list.size();
	}
	
	
	public static void main(String[] args) {
		
		final Test10 test10=new Test10();
		
		
		/**
		 * 两个生产者线程
		 */
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					try{
						test10.lock.lock();
						while(test10.getListSize()==10){
							System.out.println(Thread.currentThread().getName()+"在等待");
							test10.produce.await();
						}
						while(test10.getListSize()<10){
							test10.addOne(test10.getListSize()+1);
							System.out.println(Thread.currentThread().getName()+"生产了1个;库存:"+test10.getListSize());
						}
						//通知消费者消费
						test10.consumer.signalAll();
					}catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						test10.lock.unlock();
					}
				}
			},"p"+i).start();
		}
		
		
		
		/**
		 * 五个消费者线程
		 */
		for(int i=0;i<5;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					try{
						test10.lock.lock();
						while(test10.getListSize()==0){
							System.out.println(Thread.currentThread().getName()+"在等待");
							test10.consumer.await();
						}
						test10.getOne();
						System.out.println(Thread.currentThread().getName()+"消费了1个;库存:"+test10.getListSize());
						//通知生产者生产
						test10.produce.signalAll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally{
						test10.lock.unlock();
					}
				}
				
			},"c"+i).start();
		}
		
		
		
	}
	

}
