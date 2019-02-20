package com.yb.banking.vo;

import org.springframework.stereotype.Component;

@Component
public class Branch {
	
	private int branchCode;
	private String branchName;
	private String manager;
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Branch [branchCode=" + branchCode + ", branchName=" + branchName + ", manager=" + manager + "]";
	}
	
}
