package com.yb.banking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yb.banking.vo.Branch;

@Mapper
public interface BranchMapper {
	
	// 지점 조회(전체)
	List<Branch> branch();
	
	// 지점 조회(하나)
	Branch branchOne(int branchCode);
}
