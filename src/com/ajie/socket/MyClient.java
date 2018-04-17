package com.ajie.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author niezhenjie
 * 
 */
public class MyClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.0.50",9999);
	}
}
