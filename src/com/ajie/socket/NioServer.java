package com.ajie.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * @author niezhenjie
 * 
 */
public class NioServer {

	/** 处理请求后的事件的线程池 */
	protected ExecutorService threadPool;
	/** 统一管理通道的选择器 */
	protected Selector selector;
	/** 发送换从去 */
	protected ByteBuffer sendBuf;
	/** 接收缓冲区 */
	protected ByteBuffer getBuf;

	public NioServer(int port) {
		try {
			ServerSocketChannel channel = ServerSocketChannel.open();
			channel.configureBlocking(false);
			ServerSocket socket = channel.socket();
			socket.bind(new InetSocketAddress(port));
			selector = Selector.open();
			channel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("server listen in port "+port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 轮询事件
	 * @throws IOException 
	 */
	public void poll() throws IOException{
		while(true){
			selector.select(); //会一直阻塞到有一个以上的连接
			Set<SelectionKey> key = selector.selectedKeys();//拿到所有就绪的key
			Iterator<SelectionKey> iterator = key.iterator();
			while(iterator.hasNext()){
				SelectionKey k = 	iterator.next();
				iterator.remove();
				
			}
		}
	}

}
