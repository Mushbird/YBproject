package com.yb.banking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yb.banking.vo.UserOrder;

@Mapper
public interface UserOrderMapper {
	// mypage에서 주문하기
	int UserOrder(UserOrder UserOrder);
	
	// mypage에서 주문조회
	List<UserOrder> orderList(String clientId);
	
	// 전체 주문조회
	List<UserOrder> allOrderList();
}
