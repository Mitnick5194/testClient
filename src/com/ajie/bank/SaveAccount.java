package com.ajie.bank;

/**
 * @author Mitnick
 * 
 */
public class SaveAccount extends Account {

	public SaveAccount(String id) {
		this(id, 0);
	}

	public SaveAccount(String id, double balance) {
		super(id, balance);
	}

	public boolean withdraw(double amount) {
		return super.withdraw(amount);
	}

}
