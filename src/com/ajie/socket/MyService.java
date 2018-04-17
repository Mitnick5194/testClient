package com.ajie.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @author niezhenjie
 * 
 */
public class MyService {

	public static void main(String[] args) throws IOException {
		ThreadTest tt = new ThreadTest("1");
		Thread t = new Thread(tt);
		// 在下面的阻塞之前开了一个线程 内存有了一个线程（主线程创建了这线程 这线程就与主线程无关了）
		// 所以下面主线程的阻塞不会影响我这个线程
		t.start();
		ServerSocket server = new ServerSocket(9999);
		System.out.println("服务器在9999端口阻塞监听");
		// 阻塞了 不能往下执行 而且只要有一个连进来 就会往下执行
		// 即只能连接一个（因为只有一个主线程 如果需要连接多个 则需要将每个连接都做成一个线程）
		server.accept();
		//因为上面这行会被阻塞 导致这里的代码没法执行到 所以就不能创建tt2线程 知道阻塞结束
		ThreadTest tt2 = new ThreadTest("2");
		Thread t2 = new Thread(tt2);
		t2.start();
		InetSocketAddress localSocketAddress = (InetSocketAddress) server.getLocalSocketAddress();
		System.out.println("连接成功  " + localSocketAddress.getAddress());
	}
}

class ThreadTest implements Runnable {
	String name;
	public ThreadTest(String name){
		this.name = name;
	}
	@Override
	public void run() {
		while (true) {
			try {
				sayHello();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void sayHello() {
		System.out.println(this.name + ": hello world");
	}

}
