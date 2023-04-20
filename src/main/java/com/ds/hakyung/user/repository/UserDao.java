package com.ds.hakyung.user.repository;

import java.util.List;

import com.ds.hakyung.user.domain.UserDto;

public interface UserDao {
	void insert(UserDto dto);
	List<UserDto> getList(UserDto dto);
	UserDto getInfo(UserDto dto);
	List<UserDto> getHobbyList(UserDto dto);
	void update(UserDto dto);
	void delete(UserDto dto);
	List<UserDto> getSearchList(UserDto dto);
	int userIdCheck(UserDto dto);
}
