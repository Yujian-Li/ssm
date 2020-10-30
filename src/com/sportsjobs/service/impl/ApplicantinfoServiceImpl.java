package com.sportsjobs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsjobs.mapper.ApplicantinfoMapper;
import com.sportsjobs.pojo.Applicantinfo;
import com.sportsjobs.service.ApplicantinfoService;

@Service
public class ApplicantinfoServiceImpl implements ApplicantinfoService {

	@Autowired
	private ApplicantinfoMapper applicantinfoMapper;
	@Override
	public Applicantinfo getApplicantByNameAndPwd(String applicantAccount) {
		Applicantinfo a = applicantinfoMapper.getApplicantByNameAndPwd(applicantAccount);
		return a;
	}
	@Override
	public List<Applicantinfo> getApplicants(Map<String, Object> map) {
		return applicantinfoMapper.getApplicants(map);
	}
	@Override
	public int getApplicantTotal() {
		return applicantinfoMapper.getApplicantTotal();
	}
	@Override
	public Applicantinfo getApplicantById(int applicantId) {
		return applicantinfoMapper.getApplicantById(applicantId);
	}
	@Override
	public int isUpdateApplicant(Applicantinfo applicant) {
		return applicantinfoMapper.isUpdateApplicant(applicant);
	}
	@Override
	public int isAddApplicant(Applicantinfo applicant) {
		return applicantinfoMapper.isAddApplicant(applicant);
	}
	@Override
	public int isDelApplicant(Integer applicantId) {
		return applicantinfoMapper.isDelApplicant(applicantId);
	}

}
