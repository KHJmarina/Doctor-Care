package com.lec.projectS_medical.beans;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface BoardDAO {
	public ArrayList<BoardDTO> select();
	public int insert(final BoardDTO dto);
	public int insert(String subject, String subtitle, String content, String name, String phonenum, String email);
	//public BWriteDTO readById(int id);
	public BoardDTO selectById(int uid);
	//public int update(BWriteDTO dto);
	public int update(int uid, @Param("a") BoardDTO dto);
	public int deleteById(int uid);
	public int incViewCnt(int uid);  // 조회수 증가용
	
	public BoardDTO searchBySubject(String subject);
	
	
	
	// 페이징용 List
	// fromrow : 몇번째 row부터?
	// writePages : 몇개의 데이터 (몇개의 게시글)?
	public ArrayList<BoardDTO> selectByRow(
			@Param("fromRow") int fromRow,
			@Param("writePages") int writePages);
	
	
	
	// 여러개 delete 하기, 배열이 매개변수
	public int deleteItemsById(@Param("idList") int [] ids);
	
	
	
	
}







