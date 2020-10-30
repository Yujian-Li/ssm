package com.sportsjobs.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.BaseDict;

@Repository
public interface BaseDictService {

	public List<BaseDict> findBaseDictListByType(String typecode);
	

}
