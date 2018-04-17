package com.ajie.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author niezhenjie
 * 
 */
public class RunnableListTest {
	List<Runnable> pool = Collections.emptyList();
	public RunnableListTest(Runnable... jobs){
		pool = new ArrayList<Runnable>(jobs.length);
		for (Runnable runnable : jobs) {
			pool.add(runnable);
		}
	}
	public List<Runnable> getPool(){
		return pool;
	}
	
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3();
		RunnableListTest rlt = new RunnableListTest(t1,t2,t3);
		List<Runnable> pool2 = rlt.getPool();
		while(true){
			int i = new Random().nextInt(3);
			Runnable runnable = pool2.get(i);
			runnable.run();
		}
		
	}
}

class Thread1 implements Runnable{
	@Override
	public void run() {
		System.out.println("线程1");
	}
}
class Thread2 implements Runnable{
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程2");
	}
}
class Thread3 implements Runnable{
	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程3");
	}
}