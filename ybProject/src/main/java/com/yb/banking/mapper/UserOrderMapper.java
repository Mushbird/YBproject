package com.yb.banking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yb.banking.vo.UserOrder;

@Mapper
public interface UserOrderMapper {
	// 주문하기(화면)
	int order(UserOrder userOrder);
	
	// 주문 조회(회원)
	UserOrder orderList(UserOrder itemCode);
	
	// 최근 주문 조회(회원)
	List<UserOrder> orderListRecent(String clientId);
	
	// 주문 조회(전체)
	List<UserOrder> allOrderList();
}
