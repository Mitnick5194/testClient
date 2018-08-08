package com.ajie.tmp;

/**
 * @author niezhenjie
 * 
 */
public class Circle extends Shape implements Color {
	private double dRadius;
	private String color;

	public Circle(double r) {
		dRadius = r;
	}

	@Override
	public double getArea() {
		if (0 == dRadius) {
			return 0;
		}
		return Math.PI * dRadius * dRadius;
	}

	@Override
	public double getLength() {
		if (0 == dRadius) {
			return 0;
		}
		return 2 * Math.PI * dRadius;
	}

	@Override
	public void setColor(String clr) {
		color = clr;
	}

	@Override
	public String getColor() {
		return color;
	}

	public void printString() {
		System.out.println("我是圆形！我的半径是 " + dRadius);
	}

}
