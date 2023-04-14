package com.ds.hakyung.user.repository;

import java.util.List;

import com.ds.hakyung.user.domain.DeptDto;

public interface DeptDao {
	List<DeptDto> getList(DeptDto dto);
}
