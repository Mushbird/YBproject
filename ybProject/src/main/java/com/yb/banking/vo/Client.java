package com.yb.banking.vo;

import org.springframework.stereotype.Component;

@Component
public class Client {
	
	private String clientId;
	private String clientPw;
	private String clientName;
	private String clientAddress;
	private String clientPhone;
	private int branchCode;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientPw() {
		return clientPw;
	}
	public void setClientPw(String clientPw) {
		this.clientPw = clientPw;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientPw=" + clientPw + ", clientName=" + clientName
				+ ", clientAddress=" + clientAddress + ", clientPhone=" + clientPhone + ", branchCode=" + branchCode
				+ "]";
	}
	
}
