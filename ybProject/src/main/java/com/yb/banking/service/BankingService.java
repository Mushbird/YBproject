package com.yb.banking.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class BankingService {

	public void logout(HttpSession session) {
		session.invalidate();	
	}
}