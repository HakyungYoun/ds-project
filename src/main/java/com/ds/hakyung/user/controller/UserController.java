package com.ds.hakyung.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ds.hakyung.user.DeptService;
import com.ds.hakyung.user.HobbyService;
import com.ds.hakyung.user.UserService;
import com.ds.hakyung.user.domain.DeptDto;
import com.ds.hakyung.user.domain.HobbyDataDto;
import com.ds.hakyung.user.domain.HobbyDto;
import com.ds.hakyung.user.domain.UserDto;

import jakarta.annotation.Resource;



@Controller
public class UserController {
	@Resource(name="UserService")
	UserService service;
	
	@Resource(name="DeptService")
	DeptService service2;
	
	@Resource(name="HobbyService")
	HobbyService service3;
	
	@GetMapping("user/reg")
	String goUserReg(DeptDto dto2,Model model,HobbyDto dto3) {
		List<DeptDto> deptList=service2.getList(dto2);
		List<HobbyDto> HobbyList=service3.getList(dto3);
		model.addAttribute("deptList", deptList);
		model.addAttribute("hobbyList", HobbyList);
		return "user/userWrite";
	}
	@PostMapping("user/request")
	public String UserRequest(UserDto dto,HobbyDataDto dto4) {
		service.insert(dto);
		service3.insertHobby(dto4);
		return "redirect:/user/reg";
		
	}
	
	@GetMapping("user/manager")
	String goManagerPage() {
		
		return "user/manager";
		
	}
	
	
}
