package com.ds.hakyung.user;

import java.util.List;

import com.ds.hakyung.user.domain.UserDto;

public interface UserService {
	void insert(UserDto dto);
	List<UserDto> getList(UserDto dto);
}
