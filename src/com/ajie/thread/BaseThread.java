package com.ajie.thread;

/**
 * 创建一个线程 --> 线程就绪 --> 执行-->执行过程 可能休眠（或阻塞 此时线程并没有被销毁） --> 休眠时间到 继续回到就绪队列 
 * 
 * 等待cpu调度 在执行过程中 可能遇到阻塞 或 wait 或yeild
 * 
 * 此时释放cup执行权 等到一定时机（如睡眠时间到，io完成）  回到就绪队列
 * 
 * 
 * 普通代码只是供线程调用 是按顺序执行 而线程启动了 就等到一切时机成熟
 * 
 *  拿到cpu 在执行里面的run代码 可以在run代码里面调用其他的代码了
 *  
 *  启动了一个线程 线程可能一开始就睡眠 等到睡眠时间到了 就会回到就绪队列 等待cpu调度 这就是和其他代码的区别 
 *  
 *  其他代码只是供线程调用的 代码一执行 就会启动一个主线程 这是就能调用其他的代码了 一个线程的创建 需要另外一个线程创建
 *  
 *  所以需要一开始有一个主线程 这时候通过主线程可以随便创建自己的线程
 * 
 * 
 * @author niezhenjie
 * 
 */
public class BaseThread {

	public static void main(String[] args) {
		// 创建了一个线程 该线程就在内存里 准备好一切 等待cpu 才是休眠了5000 不会影响下面的代码执行 所以会接着创建线程2
		// 并执行线程2的内容 当5秒到了 会回到就绪状态 等待cup
		MyThread mt = new MyThread();
		Thread t = new Thread(mt);
		t.start();
		// 应为线程2只休眠了2秒 所以比线程1先回到就绪队列 等待cpu调度
		MyThread2 mt2 = new MyThread2();
		Thread t2 = new Thread(mt2);
		t2.start();
		MyThread3 mt3 = new MyThread3();
		Thread t3 = new Thread(mt3);
		t3.start();
		
		MyThread4 mt4 = new MyThread4();
		Thread t4 = new Thread(mt4);
		t4.start();
	}
}

class MyThread implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("进入了线程1");
			Thread.sleep(5000);
			System.out.println("线程1执行完毕");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class MyThread2 implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("进入线程2");
			Thread.sleep(1000);
			System.out.println("线程2执行完毕");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

class MyThread3 implements Runnable {

	@Override
	public void run() {
		int i=0;
		while (i++<3) {
			try {
				System.out.println("进入线程3");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("线程3执行完毕");
	}
}

class MyThread4 implements Runnable{

	@Override
	public void run() {
		System.out.println("进入线程4");
		Thread.yield();
		System.out.println("线程4执行完毕");
		
	}
	
	
}

