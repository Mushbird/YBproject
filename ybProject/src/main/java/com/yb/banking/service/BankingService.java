package com.yb.banking.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.banking.mapper.BankingMapper;
import com.yb.banking.vo.Account;
import com.yb.banking.vo.Client;

@Service
public class BankingService {

	@Autowired
	private BankingMapper bankingMapper;
	@Autowired
	private Client client2;
	
	// 로그인 처리
	public String login(HttpSession session, Client client) {
		// Service 도착 확인
		System.out.println("(S) 로그인 처리");
		
		// DB에서 가져오기
		client2.setClientId(client.getClientId());
		
		System.out.println("로그인 처리 시작");
		client2 = bankingMapper.login(client2);
		System.out.println("로그인 처리 완료");
		
		// DBID,PW와 받아온 id,pw를 비교
		if(client2.getClientId().equals(client.getClientId()) && client2.getClientPw().equals(client.getClientPw())) {
			// 로그인 성공 -> 로그인 정보 세션 등록
			session.setAttribute("clientId", client.getClientId());
			System.out.println("로그인 성공 , 세션 등록");
			return "redirect:/index";
			
		} else {
			// 로그인 실패 -> 로그인 호면으로 리다이렉트
			System.out.println("로그인 실패");
			return "redirect:/login";
		}
	}
	
	// 로그아웃
	public void logout(HttpSession session) {
		// Service 도착 확인
		System.out.println("(S) 로그아웃");
		// 세션 로그아웃
		session.invalidate();	
	}
	// 계좌 생성처리
	public int account(Account accountInformation) {
		// Service 도착 확인
		System.out.println("(S) 계좌 생성처리");
		
		return 0;
		
	}
	
}