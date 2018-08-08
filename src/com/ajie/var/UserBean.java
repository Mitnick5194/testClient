package com.ajie.var;

/**
 * @author niezhenjie
 * 
 */
public class UserBean {
	private String name;
	private String sex;
	private int age;

	public UserBean(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public UserBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*public String toString() {
		return "name: " + name + " sex: " + sex + " age: " + age;
	}
*/
}
