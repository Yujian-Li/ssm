package com.sportsjobs.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.Applicantinfo;

@Repository
public interface ApplicantinfoMapper {

	//Applicantinfo getApplicantByNameAndPwd(Applicantinfo applicantinfo);

	List<Applicantinfo> getApplicants(Map<String, Object> map);

	int getApplicantTotal();

	Applicantinfo getApplicantById(int applicantId);

	int isUpdateApplicant(Applicantinfo applicant);

	int isDelApplicant(Integer applicantId);

	Applicantinfo getApplicantByNameAndPwd(String applicantAccount);

	int isAddApplicant(Applicantinfo applicant);

}
