package com.sportsjobs.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.Applicantinfo;

@Repository
public interface ApplicantinfoService {

	public Applicantinfo getApplicantByNameAndPwd(String applicantAccount);
	
	public List<Applicantinfo> getApplicants(Map<String, Object> map);
	
	public int getApplicantTotal();

	public Applicantinfo getApplicantById(int applicantId);

	public int isUpdateApplicant(Applicantinfo applicant);

	public int isAddApplicant(Applicantinfo applicant);

	public int isDelApplicant(Integer applicantId);
}
