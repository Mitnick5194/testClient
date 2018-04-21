package com.ajie.thread;

/**
 * 注意 测试main函数里 必须先创建好线程 在执行main线程的逻辑 反之 main线程会由上到下执行下去 跟subThread根本没办法
 * 
 * 实现并发
 * 
 * @author niezhenjie
 * 
 */
public class Communite {

	public static void main(String[] args) {
		final Bussnies bussnies = new Bussnies();

		// 开一个线程执行字方法
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					bussnies.sub(Thread.currentThread().getName());
				}

			}
		}, "subThread").start();
		// 主线程执行主方法
		for (int i = 1; i <= 50; i++) {
			bussnies.main(Thread.currentThread().getName());
		}
	}

}

class Bussnies {
	private boolean flag = false;

	// 子线程执行的方法
	public synchronized void sub(String threadName) {
		while (flag) { // 如果为真 执行主方法 执行子方法的线程等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// flag为false 执行一下子线程的方法
		System.out.println("线程" + threadName + "执行子方法");
		// 执行完了子线程的内容 将flag切换 通知等待线程
		flag = true;
		this.notifyAll();
	}

	public synchronized void main(String threadName) {
		while (!flag) { // flag为false时 主方法等待 执行子方法
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("线程" + threadName + "执行了主方法");
		flag = false;
		this.notifyAll();
	}
}
