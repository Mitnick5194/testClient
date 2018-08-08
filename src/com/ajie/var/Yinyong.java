package com.ajie.var;

/**
 * @author niezhenjie
 * 
 */
public class Yinyong {

	public static void main(String[] args) {
		UserBean ub = new UserBean("ajie", "男", 24);
		UserBean ub2 = ub; // 引用赋值 ub2指向的内存地址和ub1一样
		ub.setAge(25); // 改变ub ub2同样会改变
		// System.out.println("ub:" + ub.toString());
		// System.out.println("ub2: " + ub2.toString());

		UserBean author = new UserBean("路遥", "男", 55);
		Book book = new Book("平凡的世界", 198, author);
		UserBean at = book.getAuthor();
		//如果改为下面的方法 效果是一样的
		//UserBean at = book.author;
		book.setAuthor(ub2); // 这里的改变并不会导致at的变化
		// 这里打印出来的author地址：author: {com.ajie.var.UserBean@3d6a2c7b}
		System.out.println(book.toString());
		// 这里的地址：com.ajie.var.UserBean@58e5ebd 所以他们并不是指向内存中的同一个地址
		System.out.println(at.toString());
	}
}
