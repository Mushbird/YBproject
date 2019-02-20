package com.yb.banking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yb.banking.service.BankingService;
import com.yb.banking.vo.Account;
import com.yb.banking.vo.Client;

@Controller
public class BankingController {
	@Autowired private BankingService bankingService;
	
	// 1. 로그인 화면
	@GetMapping("/login")
	public String login() {
		// Controller 도착 확인
		System.out.println("(C) 로그인 화면 ");
		return "login";
	}
	
	// 2. 로그인 처리
	@PostMapping("/login")
	public String login(HttpSession session, Client client) {
		// Controller 도착 확인
		System.out.println("(C) 로그인 처리 ");
		// 받아온 ID와 PW
		System.out.println(client.getClientId());
		System.out.println(client.getClientPw());
		// 로그인 처리 실행
	
		return bankingService.login(session, client);
	}
	
	// 3. 메인 화면
	@GetMapping("/index")
	public String index() {
		// Controller 도착 확인
		System.out.println("(C) 메인 화면 ");
		return "index";
	}
	
	// 4. 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// Controller 도착 확인
		System.out.println("(C) 로그아웃 ");
		bankingService.logout(session);
		return "redirect:/login";		
	}
	
	// 5. 계좌 생성화면
	@GetMapping("/account")
	public String account() {
		// Controller 도착 확인
		System.out.println("(C) 계좌 생성 화면 ");
		return "account";
	}
	
	// 6. 계좌 생성처리
	@PostMapping
	public String account(Account accountInformation) {
		// Controller 도착 확인
		System.out.println("(C) 계좌 생성처리 ");
		bankingService.account(accountInformation);
		return "index";
	}
	
	// 6. 계좌 조회(하나)
	
	// 7. 주문 조회
	
	// 8. 종목 조회(검색)
	
	// 9. 종목 주문
	
	// 10. 관리점 조회
	
	
}
