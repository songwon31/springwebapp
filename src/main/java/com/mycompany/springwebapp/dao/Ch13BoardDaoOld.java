package com.mycompany.springwebapp.dao;

import java.util.List;

import com.mycompany.springwebapp.dto.Ch13Board;
import com.mycompany.springwebapp.dto.Ch13Pager;

public interface Ch13BoardDaoOld {
	public int insert(Ch13Board board);
	public List<Ch13Board> selectByPage(Ch13Pager pager);
	public Ch13Board selectByBno(int bno);
	public int updateByBno(Ch13Board board);
	public int deleteByBno(int bno);
	public int count();
	
}
