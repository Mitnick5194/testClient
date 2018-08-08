package com.ajie.others;

/**
 * @author niezhenjie
 * 
 */
public class Test {
	public static void main(String[] args) {/*
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		String s_sb = sb.toString();
		System.out.println(s_sb.substring(0, s_sb.length()-1));
	*/
		String s = "12.343";
		float parseFloat = Float.parseFloat(s);
		System.out.println(parseFloat);
	}
}

class A {
	String name;
}
class B extends A{
	int age;
	public B(String name , int age){
		this.age = age;
		super.name = name;
	}
}
