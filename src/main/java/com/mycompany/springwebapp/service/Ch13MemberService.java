package com.mycompany.springwebapp.service;

import com.mycompany.springwebapp.dto.Ch13Member;

public interface Ch13MemberService {
	public enum LoginResult {
		SUCCESS,
		FAIL_MID,
		FAIL_MPASSWORD,
		FAIL_ENABLED
	}
	
	public void join(Ch13Member member);
	public LoginResult login(Ch13Member member);
	public void modify(Ch13Member member);
	public void unjoin(String mid);
	public void logout(String mid);
	public Ch13Member getMember(String mid);
}
