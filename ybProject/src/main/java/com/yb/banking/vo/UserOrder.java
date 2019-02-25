package com.yb.banking.vo;

import org.springframework.stereotype.Component;

@Component
public class UserOrder {
	
	private String orderDay;
	private int orderNumber;
	private String accountNumber;
	private String clientId;
	private int itemCode;
	private int orderCount;
	private int orderPay;
	public String getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(String orderDay) {
		this.orderDay = orderDay;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getOrderPay() {
		return orderPay;
	}
	public void setOrderPay(int orderPay) {
		this.orderPay = orderPay;
	}
	@Override
	public String toString() {
		return "UserOrder [orderDay=" + orderDay + ", orderNumber=" + orderNumber + ", accountNumber=" + accountNumber
				+ ", clientId=" + clientId + ", itemCode=" + itemCode + ", orderCount=" + orderCount + ", orderPay="
				+ orderPay + "]";
	}
	
}
