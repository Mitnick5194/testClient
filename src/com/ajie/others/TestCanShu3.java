package com.ajie.others;

/**
 * @author niezhenjie
 * 
 */
public class TestCanShu3 {

	public static void main(String[] args) {
		TestCanShu3 tcs = new TestCanShu3();
		Animal a = new Animal();
		Animal dog = tcs.update(a);
		System.out.println(a instanceof Dog);
		System.out.println(dog instanceof Dog);
	}
	public Animal update(Animal animal){
		animal = new Dog();
		return animal;
	}
}
class Animal{
	String name;
	int age;
}

class Monkey extends Animal{
	int height;
}
class Dog extends Animal{
	int weight;
}
