package com.example.demo.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * threadpool线程池
 * @author Administrator
 *
 */
public class Test13 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//五个线程的固定线程池
		ExecutorService service=Executors.newFixedThreadPool(5);
		//6个任务扔进去
		for(int i=0;i<10;i++){
			service.execute(new Runnable(){
				@Override
				public void run() {
					try {
						Thread.currentThread().sleep(500);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			});
		}
		
		
		
		//未来任务?
		Future<Integer> future=service.submit(new Callable(){
			@Override
			public Object call() throws Exception {
				Thread.currentThread().sleep(1000);
				return 1000;
			}
		});
		
		System.out.println(future.get());
		
	}

}
