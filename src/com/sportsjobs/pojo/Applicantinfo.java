package com.sportsjobs.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Applicantinfo {
	private Integer applicantId;
	private String applicantName;
	private String applicantAccount;
	private String applicantGender;
	private String applicantPwd;
	private List<Skill> skills;
	private List<String> skillsId;
	
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
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
	public String getApplicantPwd() {
		return applicantPwd;
	}
	public void setApplicantPwd(String applicantPwd) {
		this.applicantPwd = applicantPwd;
	}
	public String getApplicantGender() {
		return applicantGender;
	}
	public void setApplicantGender(String applicantGender) {
		this.applicantGender = applicantGender;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public List<String> getSkillsId() {
		return skillsId;
	}
	public void setSkillsId(List<String> skillsId) {
		this.skillsId = skillsId;
	}
	
	
	
}
