package com.gdu.cast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.cast.service.AdminService;
import com.gdu.cast.vo.Admin;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
	// 관리자 메인페이지
	@GetMapping("/adminIndex")
	public String adminIndex() {
		return "admin/adminIndex";
	}
	
	// 관리자 로그인페이지
	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "admin/adminLogin";
	}
	
	// 관리자 로그인
	@PostMapping("/adminLogin")
	// 비밀번호 (password)처리...
	public String postCustomerSignUp(HttpSession session, Admin admin) {
		System.out.println(admin.getAdminId() + "<-adminContrlloer");
		System.out.println(admin.getAdminPw() + "<-adminContrlloer");
		Admin loginAdmin = adminService.getSelectAdmin(admin);
		System.out.println(loginAdmin + "<-adminContrlloer"); // 관리자 id, 관리자 이름
		if(loginAdmin == null) {
			return "redirect:/adminLogin";
		}
		session.setAttribute("loginAdminId", loginAdmin.getAdminId());
		System.out.println(session.getAttribute("loginAdminId"));
		return "redirect:/adminIndex";
	}
}