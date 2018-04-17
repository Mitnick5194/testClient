package com.ajie.fanxing;

import com.ourlinc.tern.Mapper;

/**
 * @author niezhenjie
 * 
 */
public class TestDoubleE{
	
	/**
	 * class没有带E所以这里如果前面没有<E> 后面的Mapper<? extends E>就会报错
	 * @param mapper
	 * @param clazz
	 */
	public <E> void regsiter(Mapper<? extends E> mapper, Class<E> clazz){
		
	}

}
