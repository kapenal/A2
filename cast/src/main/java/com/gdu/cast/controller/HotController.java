package com.gdu.cast.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.cast.service.HotService;
import com.gdu.cast.vo.Address;
import com.gdu.cast.vo.Hotel;
import com.gdu.cast.vo.Room;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HotController {
	@Autowired
	HotService hotService;
	
	// 호텔 등록
	@GetMapping("/ceo/insertHotel")
	public String insertHotel(Model model, int addressId) {
		
		model.addAttribute("addressId", addressId);
		
		return "/ceo/insertHotel";
	}
	
	@PostMapping("/ceo/insertHotel")
	public String insertHotel(HttpSession session, Hotel hotel) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		hotel.setCeoId(ceoId);
		hotService.insertHotel(hotel);
		
		log.debug("====================================" + ceoId + " << ceoId");
		log.debug("====================================" + hotel.toString() + " << hotel Debug");
		
		return "redirect:/ceo/insertRoom?hotelId="+hotel.getHotelId();
	}
	
	// 호텔주소 등록
	@GetMapping("/ceo/insertHotelAddress")
	public String insertHotelAddress() {
		return "/ceo/insertHotelAddress";
	}
	
	@PostMapping("/ceo/insertHotelAddress")
	public String insertHotelAddress(HttpSession session, Address address, Hotel hotel) {
		String ceoId = (String) session.getAttribute("loginCeoId");
		hotel.setCeoId(ceoId);
		
		hotService.insertHotelAddress(address);
		
		return "redirect:/ceo/insertHotel?addressId=" + address.getAddressId() + "&ceoId=" + hotel.getCeoId();
	}
	
	// 방 등록
	@GetMapping("/ceo/insertRoom")
	public String insertRoom(Model model, int hotelId) {
		model.addAttribute("hotelId", hotelId);
		return "/ceo/insertRoom";
	}
	
	@PostMapping("/ceo/insertRoom")
	public String insertRoom(Room room) {
		hotService.insertRoom(room);
		
		return "/ceo/ceoIndex";
	}
	
	// 호텔리스트
	@GetMapping("/ceo/hotelList")
	public String roomSelectList(Model model, 
		@RequestParam(defaultValue = "1") int currentPage, String ceoId) {
		log.debug(ceoId);
		final int ROW_PER_PAGE = 10;
		Map<String, Object> map = hotService.getHotelList(ceoId, currentPage, ROW_PER_PAGE);
		model.addAttribute("hotelList", map.get("hotelList"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("ceoId", ceoId);
		System.out.println(model + "model");
		return "/ceo/hotelList";
	}
}