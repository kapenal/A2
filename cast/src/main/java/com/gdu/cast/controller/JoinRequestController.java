package com.gdu.cast.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.JoinRequestService;
import com.gdu.cast.vo.JoinTraveler;
import com.gdu.cast.vo.Notice;
import com.gdu.cast.vo.Traveler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class JoinRequestController {
	@Autowired
	JoinRequestService joinRequestService;
	
	private final int ROW_PER_PAGE = 10;
	
	// 여행작가 가입 요청 리스트
	@GetMapping("/admin/travelerJoinRequestList")
	public String travelerJoinRequestList(Model model,
			@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(required = false) String state,
			@RequestParam(required = false) String searchTitle) {
		// 페이지 수, 검색어 디버깅
		System.out.println(currentPage + " <-----JoinRequestController");
		System.out.println(state + " <-----JoinRequestController");
		System.out.println(searchTitle + " <-----JoinRequestController");
		// 여행작가 가입 요청 가져오기
		Map<String, Object> map = joinRequestService.getTravelerJoinRequestList(currentPage, ROW_PER_PAGE, state, searchTitle);
		System.out.print(map.get("joinTravelerList") + " <-----JoinRequestController");
		
		// 여행작가 가입 요청에 리턴 값
		model.addAttribute("joinTravelerList", map.get("joinTravelerList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("state", state);
		model.addAttribute("searchTitle", searchTitle);
		
		return"/admin/travelerJoinRequestList";	
	}
	
	// 여행작가 가입 리스트에서 상세보기
	@GetMapping("/admin/travelerSelectOne")
	public String getTravelerOne(Model model, String joinTravelerId) {
		System.out.println(joinTravelerId + " <-----JoinRequestController");
		JoinTraveler joinTraveler = joinRequestService.getTravelerOne(joinTravelerId);
		log.debug(joinTraveler.toString());
		model.addAttribute("joinTraveler",joinTraveler);
		return"/admin/travelerSelectOne";
	}
	
	// 여행작가 상세보기에서 가입 승인 시
	@GetMapping("/admin/updateTravelerJoinRequest")
	public String travelerJoinRequestCancel(String joinTravelerId,String adminId, String state) {
		// 디버깅
		System.out.println(joinTravelerId + " <-----JoinRequestController");
		System.out.println(adminId + " <-----JoinRequestController");
		System.out.println(state + " <-----JoinRequestController");
		joinRequestService.updateTravelerJoinRequest(joinTravelerId, adminId, state);
		return"redirect:/admin/travelerJoinRequestList";
	}
	
	// 가입 요청 중이면 보여지는 페이지 이동
	@GetMapping("/requesting")
	public String requesting(int result) {
		System.out.println(result + " <-----JoinRequestController");
		if(result == 1) {
			return"joinRequesting";
		}
		return"joinRequestCancel";
	}
	
	// 가입 실패 시 여행작가 회원가입 삭제
	@GetMapping("/deleteTraveler")
	public String deleteTraveler(HttpSession session, String travelerId) {
		System.out.println(travelerId);
		joinRequestService.deleteTravelerJoinRequest(travelerId);
		session.invalidate();
		return"redirect:/customersingup";
	}

}
