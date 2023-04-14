package com.ds.hakyung.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ds.hakyung.user.UserService;
import com.ds.hakyung.user.domain.UserDto;

import jakarta.annotation.Resource;



@Controller
public class UserController {
	@Resource(name="UserService")
	UserService service;
	
	@GetMapping("user/reg")
	String goUserReg() {
		
		return "user/userWrite";
	}
	@PostMapping("user/request")
	public String UserRequest(UserDto dto) {
		service.insert(dto);
		return "redirect:/user/reg";
		
	}
	
	
}
