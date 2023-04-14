package com.ds.hakyung.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ds.hakyung.user.DeptService;
import com.ds.hakyung.user.UserService;
import com.ds.hakyung.user.domain.DeptDto;
import com.ds.hakyung.user.domain.UserDto;

import jakarta.annotation.Resource;



@Controller
public class UserController {
	@Resource(name="UserService")
	UserService service;
	
	@Resource(name="DeptService")
	DeptService service2;
	
	@GetMapping("user/reg")
	String goUserReg(DeptDto dto2,Model model) {
		List<DeptDto> deptList=service2.getList(dto2);
		model.addAttribute("deptList", deptList);
		return "user/userWrite";
	}
	@PostMapping("user/request")
	public String UserRequest(UserDto dto) {
		service.insert(dto);
		return "redirect:/user/reg";
		
	}
	
	
}
