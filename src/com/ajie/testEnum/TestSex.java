package com.ajie.testEnum;

/**
 * @author niezhenjie
 * 
 */
public class TestSex {

	public static void main(String[] args) {
		System.out.println(Sex.male.getId());
		Sex sex = Sex.findSexById(3);
		System.out.println(sex.name);
		System.out.println(sex.birthday);
	}

}
