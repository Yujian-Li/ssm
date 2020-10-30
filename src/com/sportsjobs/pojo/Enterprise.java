package com.sportsjobs.pojo;

import org.springframework.stereotype.Component;

@Component
public class Enterprise {

	private Integer enterpriseId;
	private String enterpriseName;
	private String enterpriseSpec;
	private String enterpriseAccount;
	private String enterprisePwd;
	public Integer getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getEnterpriseSpec() {
		return enterpriseSpec;
	}
	public void setEnterpriseSpec(String enterpriseSpec) {
		this.enterpriseSpec = enterpriseSpec;
	}
	public String getEnterpriseAccount() {
		return enterpriseAccount;
	}
	public void setEnterpriseAccount(String enterpriseAccount) {
		this.enterpriseAccount = enterpriseAccount;
	}
	public String getEnterprisePwd() {
		return enterprisePwd;
	}
	public void setEnterprisePwd(String enterprisePwd) {
		this.enterprisePwd = enterprisePwd;
	}
	
	
	
}
