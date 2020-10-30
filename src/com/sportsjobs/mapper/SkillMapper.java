package com.sportsjobs.mapper;

import java.util.List;
import java.util.Map;

import com.sportsjobs.pojo.Skill;

public interface SkillMapper {

	List<Skill> getSkillsByApplicantId(Integer applicantId);
	
	List<String> getSkillsByAppId(Integer applicantId);

	Map<String, String> getSkillsList();
	
	List<Skill> getAllSkills();
	
	List<String> getAllSkillsId();
	
	int deleteByApplicantId(Integer applicantId);
	
	int insertApplicantSkill(Integer applicantId, String skillId);
}
