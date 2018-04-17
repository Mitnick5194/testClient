package com.ajie.others;

/**
 * @author niezhenjie
 * 
 */
public class Fanxing {
	UserInfo userInfo;
	public static void main(String[] args) {
		Fanxing fx = new Fanxing();
		UserInfo ur= (UserInfo)fx.getUserInfo();
		String name = ur.name;
		int age = ur.age;
		System.out.println("name="+name+" age="+age);
	
	}
	public Fanxing(){
		userInfo = new UserInfo();
		userInfo.name = "ajie";
		userInfo.age = 24;
	}
	PersonInfo getUserInfo(){
		return userInfo;
	}
	public String getName(){
		return userInfo.name;
	}
}


interface PersonInfo{
	
}
class UserInfo implements PersonInfo{
	String name;
	int age;
	
}