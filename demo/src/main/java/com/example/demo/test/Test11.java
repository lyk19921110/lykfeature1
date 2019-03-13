package com.example.demo.test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * test bolckingqueue阻塞队列消费者生产者模式
 * @author Administrator
 *
 */
public class Test11 { 
	
	static BlockingQueue<String> block=new LinkedBlockingQueue<String>();
	static Random r=new Random();
	
	
	public static void main(String[] args) {
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<100;i++){
					try {
						block.add("a"+i);
						System.out.println(Thread.currentThread().getName()+"生产:"+"a"+i);
						Thread.currentThread().sleep(r.nextInt(1000));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			
		},"生产者").start();

		for(int i=0;i<5;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					while(true){
					try {
							System.out.println(Thread.currentThread().getName()+"消费了:"+block.take());
							Thread.currentThread().sleep(r.nextInt(1000));
					} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
			},"消费者:"+i).start();
		}
	}
	
	

}
