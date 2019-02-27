package com.yb.banking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yb.banking.mapper.AccountMapper;
import com.yb.banking.mapper.BranchMapper;
import com.yb.banking.mapper.ClientMapper;
import com.yb.banking.mapper.UserOrderMapper;
import com.yb.banking.vo.Account;
import com.yb.banking.vo.Branch;
import com.yb.banking.vo.Client;
import com.yb.banking.vo.UserOrder;

@Service
public class BankingService {

	@Autowired private ClientMapper clientMapper;
	@Autowired private BranchMapper branchMapper;
	@Autowired private AccountMapper accountMapper;
	@Autowired private UserOrderMapper userOrderMapper;
	@Autowired private Client client2;
	@Autowired private UserOrder userOrder;
	
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
			session.setAttribute("clientName", client2.getClientName());
			System.out.println("clientName : "+client2.getClientName());
			// 계좌 갯수 세션 등록
			session.setAttribute("accountCheck", accountMapper.accountCheck(client.getClientId()));
			System.out.println("로그인 성공 , 세션 등록");
			return "redirect:/index";
			
		} else {
			// 로그인 실패 -> 로그인 화면으로 리다이렉트
			System.out.println("로그인 실패");
			return "redirect:/index";
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
	public int account(HttpSession session, Account accountInformation, String branchCode) {
		// Service 도착 확인
		System.out.println("(S) 계좌 생성처리");
		
		// 회원 id정보 세팅
		accountInformation.setClientId((String)session.getAttribute("clientId"));
		
		// 선택한 지점 정보(하나) 가져오기
		Branch branchOne = branchMapper.branchOne(branchCode);
		
		// 지점 이름과 담당자를 계좌 생성 입력에 세팅
		accountInformation.setAccountCreateBranch(branchOne.getBranchName());
		accountInformation.setAccountManager(branchOne.getManager());

		// 계정 생성처리
		accountMapper.account(accountInformation);
		// 계좌 갯수 갱신
		session.setAttribute("accountCheck", accountMapper.accountCheck((String)session.getAttribute("clientId")));
		
		System.out.println("(S) 계좌 생성완료");
		return 0;
		
	}
	
	// 계좌 정보
	public List<Account> accountInformation(String ClientId) {
		// Service 도착 확인
		System.out.println("(S) 계좌 정보");
		// 계좌 정보 가져오기
		List<Account> accountList = accountMapper.accountInformation(ClientId);
		return accountList;
	}
	
	// 내 주문 내역
	public Map<String,Object> orderList(String clientId) {
		// Service 도착 확인
		System.out.println("(S) 내 주문 내역");
		// 리턴을 위한 선언
		Map<String,Object> map = new HashMap<String,Object>();
		userOrder.setClientId(clientId);
		
		// 주문 내역 가져오기
		
		// 순금인 경우
		userOrder.setItemCode(300);
		
		UserOrder orderListGold = userOrderMapper.orderList(userOrder);
		map.put("orderListGold", orderListGold);
		
		// 18K인 경우
		userOrder.setItemCode(200);
		UserOrder orderList18K = userOrderMapper.orderList( userOrder);
		map.put("orderList18K", orderList18K);
		System.out.println("map = "+ map);
		// 14K인 경우
		userOrder.setItemCode(100);
		UserOrder orderList14K = userOrderMapper.orderList( userOrder);
		map.put("orderList14K", orderList14K);
				
		// 은인 경우
		userOrder.setItemCode(20);
		UserOrder orderListSilver = userOrderMapper.orderList( userOrder);
		map.put("orderListSilver", orderListSilver);
				
		// 백금인 경우
		userOrder.setItemCode(50);
		UserOrder orderListPlatinum = userOrderMapper.orderList(userOrder);
		map.put("orderListPlatinum", orderListPlatinum);
		
		return map;
	}
	
	// 최근 내 주문 내역 (5개)
		public List<UserOrder> orderListRecent(String ClientId) {
			// Service 도착 확인
			System.out.println("(S) 최근 내 주문내역");
			// 주문 내역 가져오기
			List<UserOrder> orderListRecent = userOrderMapper.orderListRecent(ClientId);
			return orderListRecent;
	}
		
	// 주문 하기
	public void UserOrder(UserOrder userOrder) {
		// Service 도착 확인
		System.out.println("(S) 주문하기");
		userOrderMapper.order(userOrder);
	}
	
	// 전체 주문 조회
	// 관리점 조회
	
}