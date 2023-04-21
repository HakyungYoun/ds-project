package com.ds.hakyung.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.hakyung.user.domain.DeptDto;
import com.ds.hakyung.user.repository.DeptDao;

import javax.annotation.Resource;

@Service("DeptService")
public class DeptServiceImpl implements DeptService{

	@Resource(name="DeptDao")
	DeptDao dao;
	
	@Override
	public List<DeptDto> getList(DeptDto dto) {
		return dao.getList(dto);
	}

}
