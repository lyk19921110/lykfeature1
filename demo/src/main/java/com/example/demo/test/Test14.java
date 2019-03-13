package com.example.demo.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * futureTask未来任务?
 * @author Administrator
 *
 */
public class Test14 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<Integer> task=new FutureTask<>(new Callable(){
			@SuppressWarnings("static-access")
			@Override
			public Object call() throws Exception {
				Thread.currentThread().sleep(5000);
				return 1000;
			}
			
		});
		new Thread(task).start();
		System.out.println(task.get());
	}

}
