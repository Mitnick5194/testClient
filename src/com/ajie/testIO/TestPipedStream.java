package com.ajie.testIO;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流 必须配对使用 否则无意义
 * 
 * 输出管道 负责吧数据write到输入管道的buffer缓存 输入管道绑定有相关线程 线程就从缓存里读取数据
 * 
 * @author niezhenjie
 * 
 */
public class TestPipedStream {
	public static void main(String[] args) {
		SenderThread sender = new SenderThread();
		PipedOutputStream pos = sender.getPipedOutputStream();
		ReceiverThread receiver = new ReceiverThread();
		PipedInputStream pis = receiver.getPipedInputStream();
		try {
			// pose.connect(pis) 和pis.connect(pos) 随便一个连接就可以了
			// 因为pis.connect(pos)最终也是调起pos.connect(pis)方法
			// pos.connect(pis);
			pis.connect(pos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(sender).start(); // 开始发送数据
		new Thread(receiver).start(); // 接受数据
	}
}

/**
 * 发送者线程
 * 
 * @author niezhenjie
 *
 */
class SenderThread implements Runnable {

	PipedOutputStream pos;

	public SenderThread() {
		pos = new PipedOutputStream();
	}

	public PipedOutputStream getPipedOutputStream() {
		return pos;
	}

	@Override
	public void run() {
	//	 sendOneByte();
	//	sendShortMessage();
		 sendLongMessage();
	}

	// 发送单个字节的信息
	public void sendOneByte() {
		try {
			pos.write((byte) 65);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void sendShortMessage() {
		try {
			pos.write("hello pipedstream".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void sendLongMessage() {
		byte[] b = new byte[1028];
		for (int i = 0; i < 1020; i++) {
			b[i] = 1; // 前面1020个赋值1
		}
		for (int i = 1020; i < 1028; i++) {
			b[i] = 2; // 剩下的赋值2
		}
		try {
			pos.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void close() {
		try {
			pos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/**
 * 接受者线程
 * 
 * @author niezhenjie
 *
 */
class ReceiverThread implements Runnable {

	PipedInputStream pis;

	public ReceiverThread() {
		pis = new PipedInputStream();
	}

	public PipedInputStream getPipedInputStream() {
		return pis;
	}

	@Override
	public void run() {
	//	 receiveByte();
	//	receiveShortMessage();
		 readLongMessage();
	}

	public void receiveByte() {
		try {
			int n = pis.read();
			System.out.println((char)n);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void receiveShortMessage() {
		byte[] b = new byte[1024];
		try {
			int n = pis.read(b);
			System.out.println(new String(b, 0, n));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void readLongMessage() {
		byte[] b = new byte[1024];
		while (true) {
			try {
				int n = pis.read(b);
				if (-1 == n) {
					break;
				}
				for(int i=0;i<n;i++){
					System.out.print(b[i]);
				}
			} catch (IOException e) {
				e.printStackTrace();
				close();
			}
		}
		close();
	}

	public void close() {
		try {
			pis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
