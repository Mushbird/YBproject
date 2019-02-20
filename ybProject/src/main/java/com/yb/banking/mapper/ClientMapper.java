package com.yb.banking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yb.banking.vo.Client;

@Mapper
public interface ClientMapper {
	
	// 로그인 처리
	Client login(Client client);
	
	// 로그아웃 처리
	void logout(int clientId);	
	
	// 고객 조회
	List<Client> client();	
}