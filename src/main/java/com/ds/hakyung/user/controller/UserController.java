package com.ds.hakyung.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.hakyung.user.DeptService;
import com.ds.hakyung.user.HobbyService;
import com.ds.hakyung.user.UserService;
import com.ds.hakyung.user.domain.DeptDto;
import com.ds.hakyung.user.domain.HobbyDataDto;
import com.ds.hakyung.user.domain.HobbyDto;
import com.ds.hakyung.user.domain.UserDto;

import javax.annotation.Resource;



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
//	@PostMapping("user/request")
//	public String UserRequest(UserDto dto,HobbyDataDto dto4) {
//		service.insert(dto);
//		
//		String hobby_cd=dto4.getHobby_cd();
//		String[] values = hobby_cd.split(",");
//		for (String value : values) {
//			dto4.setHobby_cd(value);
//			service3.insertHobby(dto4);
//		}
//		
//		return "redirect:/user/reg";
//		
//	}
	@ResponseBody
	@RequestMapping("/user/request")
	Map<String,Object> userRequest(UserDto dto,HobbyDataDto dto4){
		service.insert(dto);
		String hobby_cd=dto4.getHobby_cd();
		String[] values = hobby_cd.split(",");
		for (String value : values) {
			dto4.setHobby_cd(value);
			service3.insertHobby(dto4);
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("result", "success");
		return map;
	}
	@ResponseBody
	@GetMapping(value="/user/idcheck")
	Map<String,String> userIdCheck(UserDto dto){
		Map<String,String> map=new HashMap<String,String>();
		if(service.userIdCheck(dto)) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		return map;
	}
	
	@GetMapping("user/manager")
	String goManagerPage(UserDto dto,Model model,DeptDto dto2,HobbyDto dto3,String searchKeyword) {
		List<UserDto> userList=service.getList(dto);
		List<DeptDto> deptList=service2.getList(dto2);
		List<HobbyDto> HobbyList=service3.getList(dto3);
		List<UserDto> searchList=service.getSearchList(dto);
		if(searchKeyword==null ||searchKeyword=="") {
			model.addAttribute("userList", userList);
		}else {
			model.addAttribute("userList",searchList);
		}
		
		
		model.addAttribute("hobbyList", HobbyList);
		model.addAttribute("deptList", deptList);
		return "user/manager";
		
	}
	@ResponseBody
	@GetMapping("user/info")
	public Map<String,String> userInfo(UserDto dto){
		Map<String,String> map=new HashMap<String,String>();
		UserDto userInfo=service.getInfo(dto);
		List<UserDto> userHbInfo=service.getHobbyList(dto);
		if(userHbInfo!=null) {
		for (int i = 0; i < userHbInfo.size(); i++) {
			UserDto uhi=userHbInfo.get(i);
			map.put("user_hobby_info"+i, uhi.getHobby_cd());
		}
		
		}
		map.put("user_id", userInfo.getUser_id());
		map.put("user_nm", userInfo.getUser_nm());
		map.put("user_eml", userInfo.getUser_eml());
		map.put("user_dept_no", userInfo.getUser_dept_no());
		map.put("user_telno", userInfo.getUser_telno());
		map.put("user_addr", userInfo.getUser_addr());
		map.put("user_aprv_yn", userInfo.getUser_aprv_yn());
		
	
		return map;
	}
	@PostMapping("user/update")
	public String userUpdate(UserDto dto,HobbyDataDto dto4) {
		service.update(dto);
		service3.delete(dto4);
		String hobby_cd=dto4.getHobby_cd();
		String[] values = hobby_cd.split(",");
		for (String value : values) {
			dto4.setHobby_cd(value);
			service3.insertHobby(dto4);
		}
		return "redirect:/user/manager";
		
	}
	@PostMapping("user/delete")
	public String userDelete(UserDto dto,HobbyDataDto dto4) {
		service.delete(dto);
			
		return "redirect:/user/manager";
		
	}
	
	}

