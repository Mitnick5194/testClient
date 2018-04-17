package com.ajie.testNIO;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author niezhenjie
 * 
 */
public class SelectorTest {

	 public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		SelectionKey register = ssc.register(selector, SelectionKey.OP_ACCEPT);
	}
	
}
