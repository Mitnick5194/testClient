package com.ajie.testIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ourlinc.tern.io.CachedInputStream;

/**
 * @author niezhenjie
 * 
 */
public class TestTernIo {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream(new File("/home/mitnick/test.txt"));
		OutputStream os = new FileOutputStream(new File("/home/mitnick/test2.txt"));
		CachedInputStream cache = new CachedInputStream(is);
		byte[] fitBytes = cache.getFitBytes();
		System.out.println(new String(fitBytes));
		is.close();
		os.close();
		cache.close();
	}

}
