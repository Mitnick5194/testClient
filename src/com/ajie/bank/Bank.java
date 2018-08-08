package com.ajie.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mitnick
 * 
 */
public class Bank {

	private List<Account> accounts;

	public Bank() {
		accounts = new ArrayList<Account>();
	}

	public synchronized boolean addAccount(Account account) {
		if (null == account) {
			return false;
		}
		accounts.add(account);
		return true;
	}

	public synchronized boolean removeAccount(Account account) {
		if (null == account) {
			return false;
		}
		accounts.remove(account);
		return true;
	}

	public Account searchAccount(String accountId) {
		if (null == accountId) {
			return null;
		}
		for (Account account : accounts) {
			if (null == account.getId()) {
				continue;
			}
			if (accountId.equals(account.getId())) {
				return account;
			}
		}
		return null;
	}

	public double getAmountOfBalance() {
		if (null == accounts || accounts.isEmpty()) {
			return 0;
		}
		double ret = 0;
		for (Account account : accounts) {
			if (null == account) {
				continue;
			}
			ret += account.getBalance();
		}
		return ret;
	}

	public double getAmmoutOfOverdraw() {
		if (null == accounts || accounts.isEmpty()) {
			return 0;
		}
		double ret = 0;
		for (Account account : accounts) {
			if (null == account) {
				continue;
			}
			if (!(account instanceof CreditAccount)) {
				continue;
			}
			CreditAccount sa = (CreditAccount) account;
			ret += sa.getOverdrawLimit(); // FIXME
		}
		return ret;
	}

}
