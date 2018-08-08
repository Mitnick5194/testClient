package com.ajie.bank;

/**
 * @author Mitnick
 * 
 */
public class Account {
	private String id;
	private double balance;

	public Account(String id) {
		this(id, 0);
	}

	public Account(String id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public synchronized void deposit(double amout) {
		if (0 == amout) {
			return;
		}
		balance += amout;
	}

	public synchronized boolean withdraw(double amount) {
		if (0 == amount) {
			return true;
		}
		balance -= amount;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
