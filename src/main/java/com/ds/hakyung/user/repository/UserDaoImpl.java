package com.ds.hakyung.user.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.hakyung.user.domain.UserDto;

@Repository("UserDao")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insert(UserDto dto) {
		sm.insert("User_insert",dto);
	}

	@Override
	public List<UserDto> getList(UserDto dto) {
		
		return sm.selectList("user_list",dto);
	}

	@Override
	public UserDto getInfo(UserDto dto) {
		return sm.selectOne("user_info",dto);
	}

	@Override
	public List<UserDto> getHobbyList(UserDto dto) {
		return sm.selectList("user_hobby_info", dto);
	}

	@Override
	public void update(UserDto dto) {
		sm.update("user_update",dto);
	}

	@Override
	public void delete(UserDto dto) {
		sm.delete("user_Delete",dto);
	}

	@Override
	public List<UserDto> getSearchList(UserDto dto) {
		return sm.selectList("searchUser",dto);
	}

	@Override
	public int userIdCheck(UserDto dto) {
		return sm.selectOne("user_idCheck",dto);
	}

}
