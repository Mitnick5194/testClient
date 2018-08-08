package com.ajie.tmp;

/**
 * @author niezhenjie
 * 
 */
public class CircleTest {
	
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		circle.setColor("红色");
		circle.printString();
		System.out.println("面积："+circle.getArea() +"  周长： "+circle.getLength() +"  颜色： "+ circle.getColor());
	}

}
