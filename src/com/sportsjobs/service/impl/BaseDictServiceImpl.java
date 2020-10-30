package com.sportsjobs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsjobs.mapper.BaseDictMapper;
import com.sportsjobs.pojo.BaseDict;
import com.sportsjobs.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictMapper baseDictMapper;

	@Override
	public List<BaseDict> findBaseDictListByType(String typecode) {
		return baseDictMapper.findBaseDictListByType(typecode);
	}

}
