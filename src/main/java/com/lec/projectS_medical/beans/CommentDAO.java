package com.lec.projectS_medical.beans;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface CommentDAO {
	public ArrayList<CommentDTO> select();
	public int insert(final CommentDTO dto);
	public int insert(String subject, String content);

	public CommentDTO selectById(int uid);

	public int update(int uid, @Param("a") CommentDTO dto);
	public int deleteById(int uid);
	public int incViewCnt(int uid);  // 조회수 증가용
	
	public CommentDTO searchBySubject(String subject);
	
	
	
	// 페이징용 List
	// fromrow : 몇번째 row부터?
	// writePages : 몇개의 데이터 (몇개의 게시글)?
	public ArrayList<BoardDTO> selectByRow(
			@Param("fromRow") int fromRow,
			@Param("writePages") int writePages);
	
	
	
	// 여러개 delete 하기, 배열이 매개변수
	public int deleteItemsById(@Param("idList") int [] ids);
	
	
	
	
}







