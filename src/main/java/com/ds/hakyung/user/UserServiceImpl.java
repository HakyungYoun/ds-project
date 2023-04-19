package com.ds.hakyung.user;

import java.util.List;

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

	@Override
	public List<UserDto> getList(UserDto dto) {
		return dao.getList(dto);
	}

	@Override
	public UserDto getInfo(UserDto dto) {
		return dao.getInfo(dto);
	}

	@Override
	public List<UserDto> getHobbyList(UserDto dto) {
		return dao.getHobbyList(dto);
	}

	@Override
	public void update(UserDto dto) {
		dao.update(dto);
	}

	@Override
	public void delete(UserDto dto) {
		dao.delete(dto);
	}

}
