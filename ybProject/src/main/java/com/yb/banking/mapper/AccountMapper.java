package com.yb.banking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yb.banking.vo.Account;
import com.yb.banking.vo.Client;

@Mapper
public interface AccountMapper {
	
	// 계좌 생성
	int account(Account account);
	
	// 계좌 갯수 확인 (유효성 검사)(3개이상인지 확인)
	int accountCheck(String ClientId);
	
	//mypage (계좌조회)화면 
	List<Account> accountInformation(String ClientId);
}
