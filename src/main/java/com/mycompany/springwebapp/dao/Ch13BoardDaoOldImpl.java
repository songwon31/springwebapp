package com.mycompany.springwebapp.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.springwebapp.dto.Ch13Board;
import com.mycompany.springwebapp.dto.Ch13Pager;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Ch13BoardDaoOldImpl implements Ch13BoardDaoOld {
	@Autowired
	private SqlSessionTemplate sst;
	
	public int insert(Ch13Board board) {
		/*
		 * com.mycompany.springwebapp.dao.Ch13BoadDao: Mapper XML 선택
		 * .insert: Mapper XML 안에 선언된 ID
		 * 리턴값: 실제 테이블에 반영된 행의 수
		 */
		int rows = sst.insert(
				"com.mycompany.springwebapp.dao.Ch13BoardDao.insert", 
				board
		);
		
		return rows;
	}
	
	public List<Ch13Board> selectByPage(Ch13Pager pager) {
		List<Ch13Board> list = sst.selectList(
				"com.mycompany.springwebapp.dao.Ch13BoardDao.selectByPage",
				pager
		);
		
		return list;
	}
	
	public Ch13Board selectByBno(int bno) {
		Ch13Board board = sst.selectOne(
				"com.mycompany.springwebapp.dao.Ch13BoardDao.selectByBno",
				bno
		);
		
		return board;
	}
	
	public int updateByBno(Ch13Board board) {
		int rows = sst.update(
				"com.mycompany.springwebapp.dao.Ch13BoardDao.updateByBno",
				board
		);
		
		return rows;
	}
	
	public int deleteByBno(int bno) {
		int rows = sst.delete(
				"com.mycompany.springwebapp.dao.mybatis.Ch13BoardDao.deleteByBno",
				bno
		);
		
		return rows;
	}
	
	@Override
	public int count() {
		return sst.selectOne("com.mycompany.springwebapp.dao.mybatis.Ch13BoardDao.count");
	}
	
}
