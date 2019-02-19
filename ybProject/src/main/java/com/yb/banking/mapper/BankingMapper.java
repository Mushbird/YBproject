package com.yb.banking.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankingMapper {

	void logout(int clientId);
}
