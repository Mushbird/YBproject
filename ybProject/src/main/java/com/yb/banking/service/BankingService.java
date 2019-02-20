package com.yb.banking.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.banking.mapper.AccountMapper;
import com.yb.banking.mapper.BranchMapper;
import com.yb.banking.mapper.ClientMapper;
import com.yb.banking.vo.Account;
import com.yb.banking.vo.Branch;
import com.yb.banking.vo.Client;

@Service
public class BankingService {

	@Autowired private ClientMapper clientMapper;
	@Autowired private BranchMapper branchMapper;
	@Autowired private AccountMapper accountMapper;
	@Autowired private Client client2;
	@Autowired private Branch branch;
	
	// 로그인 처리
	public String login(HttpSession session, Client client) {
		// Service 도착 확인
		System.out.println("(S) 로그인 처리");
		
		// DB에서 가져오기
		client2.setClientId(client.getClientId());
		
		System.out.println("로그인 처리 시작");
		client2 = clientMapper.login(client2);
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
	
	// 계좌 화면
	public List<Branch> account() {
		// Service 도착 확인
		System.out.println("(S) 계좌 화면");
		List<Branch> branchList = branchMapper.branch();
		return branchList;
	}
	
	// 계좌 생성처리
	public int account(HttpSession session, Account accountInformation, int branchCode) {
		// Service 도착 확인
		System.out.println("(S) 계좌 생성처리");
		System.out.println(branchCode + ": branchCode");
		// 회원 id정보 세팅
		int clientId = (int)session.getAttribute("clientId");
		accountInformation.setClientId(clientId);
		// 지점 정보 가져오기
		Branch branchOne = branchMapper.branchOne(branchCode);
		accountInformation.setAccountCreateBranch(branchOne.getBranchName());
		accountInformation.setAccountCreateBranch(branchOne.getManager());
		// 계정 생성처리
		accountMapper.account(accountInformation);
		
		return 0;
		
	}
	
}