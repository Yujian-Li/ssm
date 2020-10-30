package com.sportsjobs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsjobs.mapper.EnterpriseMapper;
import com.sportsjobs.pojo.Enterprise;
import com.sportsjobs.service.EnterpriseService;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
	
	@Autowired
	private EnterpriseMapper enterpriseMapper;

	@Override
	public List<Enterprise> getEnterprises(Map<String, Object> map) {
		return enterpriseMapper.getEnterprises(map);
	}

	@Override
	public int getEnterpriseTotal() {
		return enterpriseMapper.getEnterpriseTotal();
	}

	@Override
	public Enterprise getEnterpriseById(Integer enterpriseId) {
		return enterpriseMapper.getEnterpriseById(enterpriseId);
	}

	@Override
	public int isUpdateEnterprise(Enterprise enterprise) {
		return enterpriseMapper.isUpdateEnterprise(enterprise);
	}

	@Override
	public int isAddEnterprise(Enterprise enterprise) {
		return enterpriseMapper.isAddEnterprise(enterprise);
	}

	@Override
	public int isDelEnterprise(Integer enterpriseId) {
		return enterpriseMapper.isDelEnterprise(enterpriseId);
	}

	@Override
	public Enterprise getEnterpriseByName(String enterpriseAccount) {
		return enterpriseMapper.getEnterpriseByName(enterpriseAccount);
	}

}
