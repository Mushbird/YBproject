package com.yb.banking.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yb.banking.vo.Account;

@Mapper
public interface AccountMapper {
	
	// 계좌 생성
	int account(Account account);
}
