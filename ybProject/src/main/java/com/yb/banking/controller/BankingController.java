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
import com.yb.banking.vo.UserOrder;

@Controller
public class BankingController {
	@Autowired private BankingService bankingService;
	
	// 1. 로그인 화면 (사용 안함)
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
	public String account(HttpSession session, Account accountInformation, @RequestParam String branchCode) {
		// Controller 도착 확인
		System.out.println("(C) 계좌 생성처리 ");
		bankingService.account(session, accountInformation, branchCode);
		return "redirect:/mypage";
	}
	
	// 7. 마이페이지 (계좌 조회 및 주문내역) 
	@GetMapping("/mypage")
	public String mypage(Model model, HttpSession session) {
		// Controller 도착 확인
		System.out.println("(C) mypage(계좌조회) ");
		model.addAttribute("account",bankingService.accountInformation((String)session.getAttribute("clientId")));
		model.addAttribute("order", bankingService.orderList((String)session.getAttribute("clientId")));
		return "mypage";
	}
	
	// 8. 리스트 화면
	@GetMapping("/userOrderList")
	public String userOrderList() {
		// Controller 도착 확인
		System.out.println("(C) 리스트 화면 "); 
		
		return "userOrderList";
	}
	
	// 9. 주문 하기(화면)
	@GetMapping("/userOrder")
	public String userOrder(Model model, HttpSession session, @RequestParam int itemCode, @RequestParam int orderPay, @RequestParam("itemName") String itemName) {
		// Controller 도착 확인
		System.out.println("(C) userOrder(주문) ");	
		model.addAttribute("account",bankingService.accountInformation((String)session.getAttribute("clientId")));
		model.addAttribute("itemCode", itemCode);
		model.addAttribute("orderPay", orderPay);
		model.addAttribute("itemName", itemName);
		return "userOrder";
		
	}
	
	// 10. 주문 처리
	// 입력값은 REQUEST : userOrder
	@PostMapping("/userOrder")
	public String userOrder(UserOrder userOrder) {
		// Controller 도착 확인
		System.out.println("(C) userOrder(주문처리) ");
		
		bankingService.UserOrder(userOrder);
		return "redirect:/userOrderList";
		
	}
	
	// 10. 관리점 조회
	
	
}
