package com.gdu.cast.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.cast.mapper.ExhibitionMapper;
import com.gdu.cast.vo.Exhibition;

@Service
@Transactional
public class ExhibitionService {
	@Autowired
	ExhibitionMapper exhibitionMapper;
	
	// 전시소개 작성
	public void addExhibition(Exhibition exhibition) {
		exhibitionMapper.insertExhibition(exhibition);
	}
	
	// 전시소개 리스트 페이지
	public Map<String, Object> getExhibitionList(int currentPage, int ROW_PER_PAGE, String searchTitle){
		// 1. 매개변수 가공
		Map<String, Object> paramMap = new HashMap<>();
		int beginRow = 0;
		int displayPage = 10;
		int startPage = 0;
		int lastPage = 0;
		System.out.println(searchTitle + "ExhibitionService");
		beginRow = (currentPage - 1) * ROW_PER_PAGE;
		paramMap.put("beginRow", beginRow); // currentPage 가공
		paramMap.put("ROW_PER_PAGE", ROW_PER_PAGE);
		paramMap.put("searchTitle", searchTitle);
		
		// 전시소개 리스트 가져오기
		List<Exhibition> exhibitionList = exhibitionMapper.selectExhibitionList(paramMap);
		System.out.println(exhibitionList + "ExhibitionService");
		// 2. 리턴값 가공
		Map<String, Object> returnMap = new HashMap<>();
		
		
		startPage = ((currentPage - 1) / displayPage) * displayPage + 1;
		
		int totalCount = exhibitionMapper.selectExhibitionTotalCount(searchTitle);
		System.out.println(totalCount + "ExhibitionService");
		lastPage = startPage + displayPage - 1;
		int totalPage = totalCount / ROW_PER_PAGE;
		if(totalCount % ROW_PER_PAGE != 0) {
			totalPage += 1;
		}
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		
		returnMap.put("exhibitionList", exhibitionList);
		returnMap.put("startPage", startPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalPage", totalPage);
		
		return returnMap;
	}
	
	// 전시소개 상세보기
	public Exhibition getExhibitionOne(int exhibitionNo) {
		Exhibition exhibition =  exhibitionMapper.selectExhibitionOne(exhibitionNo);
		return exhibition;
	}
	
	// 전시소개 수정
	public void updateNotice(Exhibition exhibition) {
		exhibitionMapper.updateExhibition(exhibition);
	}
	
	// 전시소개 삭제
	public void deleteExhibition(Exhibition exhibition) {
		exhibitionMapper.deleteExhibition(exhibition);
	}
}
