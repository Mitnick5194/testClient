package com.ajie.testExcel;

/**
 * @author niezhenjie
 * 
 */
public class LeadingInStudent {
	// TODO
}

class Student {
	private String id;
	private String name;
	private int weight;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Student(String id, String name, int weight) {
		this.id = id;
		this.name = name;
		this.weight = weight;
	}

	public String toString() {
		return "id: " + id + " name: " + name + " weight: " + weight;
	}
}