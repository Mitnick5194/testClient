package com.ajie.testEnum;

import java.util.Date;

/**
 * @author niezhenjie
 * 
 */
public enum Sex {
	// 这是定义一个枚举 ，枚举的参数要和构造一样 多个用逗号gekai
	male(1, "man"), female(2, "women"), boy(3, "man", new Date());
	protected int id;
	protected String name;
	protected Date birthday;

	// 这是构造，前面不能带修饰符（public private ...）
	Sex(int id, String name) {
		this.id = id;
		this.name = name;
	}

	Sex(int id, String name, Date birthday) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthday() {
		return birthday;
	}

	//need static
	public static Sex findSexById(int id) {
		if (id == 1) {
			return male;
		}
		if (id == 2) {
			return female;
		} else {
			return boy;
		}
	}

}
