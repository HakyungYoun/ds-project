package com.ds.hakyung.user;

import java.util.List;

import com.ds.hakyung.user.domain.HobbyDto;

public interface HobbyService {
	List<HobbyDto> getList(HobbyDto dto);
}
