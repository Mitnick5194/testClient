package com.ajie.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author niezhenjie
 * 
 */
public class TestSyn {

	public static void main(String[] args) {
		int i = 0;
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Player p3 = new Player("p3");
		Player p4 = new Player("p4");
		Player p5 = new Player("p5");
		Player p6 = new Player("p6");
		Player p7 = new Player("p7");
		final List<Player> list = new ArrayList<Player>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		
		for(int j=0;j<1000;j++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					Player player = list.get(new Random().nextInt(7));
					Player player2 = list.get(new Random().nextInt(7));
					player.match(player2);
				}
			},++i+"").start();;
		}
		

		/*p1.match(p2);
		p3.match(p4);*/
		/*p1.match(p3);
		p1.match(p4);*/
		
		
		p1.toString();
		p3.toString();
		p2.toString();
		p4.toString();
		p5.toString();
		p6.toString();
		p7.toString();
	}
}

class Player {
	String name;
	Player matcher;
	boolean isCanMatch;

	public Player(String name) {
		this.name = name;
		isCanMatch = true;
	}

	public synchronized boolean match(Player matcher) {
		if(matcher.equals(this)){
			return false;
		}
		
		System.out.println(Thread.currentThread() + "   进来了【"+name+"】match方法");

		try {
			Thread.sleep(0000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isCanMatch) {
			isCanMatch = false;
			this.matcher = matcher;
			if(matcher.connect(this)){
				return true;
			}
		}
		return false;
	}

	public synchronized boolean connect(Player matcher) {
		System.out.println(Thread.currentThread() + "   进来了【"+name+"】connect方法");

		if (isCanMatch) {
			isCanMatch = false;
			this.matcher = matcher;
			return true;
		}
		return false;
	}

	public String toString() {
		if (null != matcher) {
			System.out.println(this.name + " 与 " + matcher.name + " 匹配成功");
		} else {
			System.out.println(this.name + " 尚未匹配");
		}
		return null;
	}

}
