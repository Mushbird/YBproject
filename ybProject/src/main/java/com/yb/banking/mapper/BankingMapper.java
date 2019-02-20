package com.yb.banking.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yb.banking.vo.Client;

@Mapper
public interface BankingMapper {
	
	// 로그인 처리
	Client login(Client client);
	
	// 로그아웃 처리
	void logout(int clientId);
	
	// 계좌 생성
}
