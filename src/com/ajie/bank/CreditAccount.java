package com.ajie.bank;

/**
 * @author Mitnick
 * 
 */
public class CreditAccount extends Account {

	private double overdrawLimit;

	public CreditAccount(String id) {
		this(id, 0);
	}

	public CreditAccount(String id, double balance) {
		this(id, balance, 10000);
	}

	public CreditAccount(String id, double balance, double overdrawLimit) {
		super(id, balance);
		this.overdrawLimit = overdrawLimit;
	}

	public synchronized boolean withdraw(double amount) {
		if (0 == amount) {
			return false;
		}
		double balance = getBalance();
		if (balance >= amount) {
			balance -= amount;
		} else {
			double over = amount - balance;
			overdrawLimit -= over;
		}
		return true;
	}

	public double getOverdrawLimit() {
		return overdrawLimit;
	}

	public void setOverdrawLimit(double overdrawLimit) {
		this.overdrawLimit = overdrawLimit;
	}

}
