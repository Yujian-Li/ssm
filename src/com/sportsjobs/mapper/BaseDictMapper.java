package com.sportsjobs.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.BaseDict;

@Repository
public interface BaseDictMapper {

	List<BaseDict> selectByTypecode(String typecode);

	List<BaseDict> findBaseDictListByType(String typecode);

	
}
