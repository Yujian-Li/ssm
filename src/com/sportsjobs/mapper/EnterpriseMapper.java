package com.sportsjobs.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.Enterprise;

@Repository
public interface EnterpriseMapper {

	List<Enterprise> getEnterprises(Map<String, Object> map);

	int getEnterpriseTotal();
	
	Enterprise getEnterpriseById(int enterpriseId);
	
	int isUpdateEnterprise(Enterprise enterprise);
	
	int isAddEnterprise(Enterprise enterprise);
	
	int isDelEnterprise(Integer enterpriseId);

	Enterprise getEnterpriseByName(String enterpriseAccount);
}
