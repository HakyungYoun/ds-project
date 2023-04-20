package com.ds.hakyung.user.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.hakyung.user.domain.HobbyDataDto;
import com.ds.hakyung.user.domain.HobbyDto;
@Repository("HobbyDao")
public class HobbyDaoImpl implements HobbyDao{
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<HobbyDto> getList(HobbyDto dto) {
		
		return sm.selectList("Hobby_list", dto);
	}

	@Override
	public void insertHobby(HobbyDataDto dto2) {
		sm.insert("hobby_insert", dto2);
		
	}

	@Override
	public void delete(HobbyDataDto dto2) {
		sm.delete("hobby_delete",dto2);
	}


}
