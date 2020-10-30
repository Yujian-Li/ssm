package com.sportsjobs.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.Skill;

@Repository
public interface SkillService {
	
	public List<Skill> getSkillsByApplicantId(Integer applicantId);
	
	public List<String> getSkillsByAppId(Integer applicantId);
	
	public List<Skill> getAllSkills();
	
	public List<String> getAllSkillsId();
	
	public int updateSkillsByApplicantId(Integer applicantId, List<String> skills);

}
