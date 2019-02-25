package com.yb.banking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "index";		
	}
	
	// 5. 계좌 생성화면
	@GetMapping("/account")
	public String account(Model model) {
		// Controller 도착 확인
		System.out.println("(C) 계좌 생성 화면 ");
		model.addAttribute("branchList", bankingService.account());
		return "account";
	}
	
	// 6. 계좌 생성처리
	@PostMapping("/account")
	public String account(HttpSession Session, Account accountInformation, @RequestParam("branchCode") String branchCode) {
		// Controller 도착 확인
		System.out.println("(C) 계좌 생성처리 ");
		bankingService.account(Session, accountInformation, branchCode);
		return "mypage";
	}
	
	// 7. 마이페이지 (계좌 조회 및 주문내역) 
	@GetMapping("/mypage")
	public String mypage(Model model, @RequestParam("clientId") String ClientId ) {
		// Controller 도착 확인
		System.out.println("(C) mypage(계좌조회) ");
		model.addAttribute("account",bankingService.accountInformation(ClientId));
		model.addAttribute("order", bankingService.orderList(ClientId));
		return "mypage";
		
	}
	
	// 8. 리스트 화면
	@GetMapping("/userOrderList")
	public String userOrderList() {
		// Controller 도착 확인
		System.out.println("(C) 리스트 화면 "); 
		
		return "userOrderList";
	}
	
	// 9. 주문 하기
	
	// 10. 관리점 조회
	
	
}
