package com.yb.banking.vo;

import org.springframework.stereotype.Component;

@Component
public class Account {
	
	private String accountNumber;
	private int clientId;
	private String accountName;
	private int deposit;
	private String accountCreateBranch;
	private String accountManager;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public String getAccountCreateBranch() {
		return accountCreateBranch;
	}
	public void setAccountCreateBranch(String accountCreateBranch) {
		this.accountCreateBranch = accountCreateBranch;
	}
	public String getAccountManager() {
		return accountManager;
	}
	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", clientId=" + clientId + ", accountName=" + accountName
				+ ", deposit=" + deposit + ", accountCreateBranch=" + accountCreateBranch + ", accountManager="
				+ accountManager + "]";
	}
	
}
