package com.ajie.bank;

/**
 * @author Mitnick
 * 
 */
public class TestBank {

	public static void main(String[] args) {
		Bank bank = new Bank();

		CreditAccount creditAccount1 = new CreditAccount("1000001", 1000, 5000);
		CreditAccount creditAccount2 = new CreditAccount("1000002", 1000, 5000);
		CreditAccount creditAccount3 = new CreditAccount("1000003", 1000, 5000);
		CreditAccount creditAccount4 = new CreditAccount("1000004", 1000, 5000);
		CreditAccount creditAccount5 = new CreditAccount("1000005", 1000, 5000);

		SaveAccount saveAccount1 = new SaveAccount("2000001", 1000);
		SaveAccount saveAccount2 = new SaveAccount("2000002", 1000);
		SaveAccount saveAccount3 = new SaveAccount("2000003", 1000);
		SaveAccount saveAccount4 = new SaveAccount("2000004", 1000);
		SaveAccount saveAccount5 = new SaveAccount("2000005", 1000);

		bank.addAccount(creditAccount1);
		bank.addAccount(creditAccount2);
		bank.addAccount(creditAccount3);
		bank.addAccount(creditAccount4);
		bank.addAccount(creditAccount5);

		bank.addAccount(saveAccount1);
		bank.addAccount(saveAccount2);
		bank.addAccount(saveAccount3);
		bank.addAccount(saveAccount4);
		bank.addAccount(saveAccount5);

		System.out.println(bank.getAmountOfBalance());

	}
}
