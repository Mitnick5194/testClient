package com.ajie.others;

import java.util.Collection;

import com.ourlinc.tern.Metatype;

/**
 * @author niezhenjie
 * 
 */
public class ClassTest {
	public static void main(String[] args) {
		System.out.println(Metatype.getSimpleName(Page.class)+"1");
		System.out.println(Page.class.getSimpleName());
	}
}

class Page{
	
}
