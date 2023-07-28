package com.mycompany.springwebapp.service;

import java.util.List;

import com.mycompany.springwebapp.dto.Ch13Board;
import com.mycompany.springwebapp.dto.Ch13Pager;

public interface Ch13BoardService {
	public void write(Ch13Board board);
	public void remove(int bno);
	public void modify(Ch13Board board);
	public List<Ch13Board> getList(Ch13Pager pager);
	public Ch13Board getBoard(int bno);
	public void addHitcount(int bno);
	public int getTotalBoardNum();
	
}
