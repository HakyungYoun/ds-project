package com.ds.hakyung.user;

import org.springframework.stereotype.Service;

import com.ds.hakyung.user.domain.UserDto;
import com.ds.hakyung.user.repository.UserDao;

import jakarta.annotation.Resource;


@Service("UserService")
public class UserServiceImpl implements UserService{

	@Resource(name="UserDao")
	UserDao dao;
	
	public void insert(UserDto dto) {
		dao.insert(dto);
	}

}
