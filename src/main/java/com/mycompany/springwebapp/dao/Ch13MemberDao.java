package com.mycompany.springwebapp.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.springwebapp.dto.Ch13Member;

@Mapper
public interface Ch13MemberDao {
	// menabled: 기본값으로 1
	// mrole: 기본값으로 "ROLE_USER"
	public int insert(Ch13Member member);	
	
	public Ch13Member selectByMid(String mid);
	
	public int update(Ch13Member member);	// mpassword, memail 수정
}
