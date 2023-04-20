package com.ds.hakyung.user;

import java.util.List;

import com.ds.hakyung.user.domain.HobbyDataDto;
import com.ds.hakyung.user.domain.HobbyDto;

public interface HobbyService {
	List<HobbyDto> getList(HobbyDto dto);
	void insertHobby(HobbyDataDto dto2);
	void delete(HobbyDataDto dto2);
}
