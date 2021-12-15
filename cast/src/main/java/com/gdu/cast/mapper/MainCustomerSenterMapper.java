package com.gdu.cast.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.cast.vo.Notice;
import com.gdu.cast.vo.Qna;

@Mapper
public interface MainCustomerSenterMapper {
	//고객페이지에 들어가는 qna리스트
	List<Qna> selectQnaList(Map<String, Object> map);
	int selectQnaTotalCount();
	
	// 고객페이지에 출력되는 공지사항 목록
	List<Notice> selectNoticeList(Map<String, Object> map);
	// 고객페이지에 출력되는 공지사항의 글갯수
	int selectNoticeTotalCount(String searchTitle);
}