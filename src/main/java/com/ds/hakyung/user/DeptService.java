package com.ds.hakyung.user;

import java.util.List;

import com.ds.hakyung.user.domain.DeptDto;

public interface DeptService {
	List<DeptDto> getList(DeptDto dto);
}
