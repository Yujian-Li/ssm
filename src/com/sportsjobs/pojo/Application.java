package com.sportsjobs.pojo;

import org.springframework.stereotype.Component;

@Component
public class Application {
	
	private Integer applicantId;
	private Integer jobId;
	private String applicantName;
	private String applicantAccount;
	private String applicantGender;
	private String jobSpec;
	public String getJobSpec() {
		return jobSpec;
	}
	public void setJobSpec(String jobSpec) {
		this.jobSpec = jobSpec;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getApplicantAccount() {
		return applicantAccount;
	}
	public void setApplicantAccount(String applicantAccount) {
		this.applicantAccount = applicantAccount;
	}
	public String getApplicantGender() {
		return applicantGender;
	}
	public void setApplicantGender(String applicantGender) {
		this.applicantGender = applicantGender;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicationId) {
		this.applicantId = applicationId;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

}
