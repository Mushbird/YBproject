package com.yb.banking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yb.banking.service.BankingService;

@Controller
public class BankingController {
	@Autowired private BankingService login;
	
	// 1. 로그인
	@PostMapping
	public String login() {
		return "login";
	}
	// 2. 로그아웃
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		login.logout(session);
		return "redirect:/login";		
	}
	// 3. (회원)계좌 조회(하나)
	
	// 4. (회원)주문 조회
	
	// 5. 종목 조회(검색)
	
	// 6. 종목 주문
	
	// 7. 관리점 조회
	
	
}
