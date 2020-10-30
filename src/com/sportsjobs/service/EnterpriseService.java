package com.sportsjobs.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.Enterprise;

@Repository
public interface EnterpriseService {
	
	public Enterprise getEnterpriseByName(String enterpriseAccount);

	public List<Enterprise> getEnterprises(Map<String, Object> map);

	public int getEnterpriseTotal();

	public Enterprise getEnterpriseById(Integer enterpriseId);

	public int isUpdateEnterprise(Enterprise enterprise);

	public int isAddEnterprise(Enterprise enterprise);

	public int isDelEnterprise(Integer enterpriseId);
}
