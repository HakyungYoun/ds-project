package com.ds.hakyung.user.repository;

import java.util.List;

import com.ds.hakyung.user.domain.HobbyDto;

public interface HobbyDao {
	List<HobbyDto> getList(HobbyDto dto);
}
