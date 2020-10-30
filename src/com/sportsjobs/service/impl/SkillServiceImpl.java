package com.sportsjobs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsjobs.mapper.SkillMapper;
import com.sportsjobs.pojo.Skill;
import com.sportsjobs.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillMapper skillMapper;

	@Override
	public List<Skill> getSkillsByApplicantId(Integer applicantId) {
		return skillMapper.getSkillsByApplicantId(applicantId);
	}
	
	@Override
	public List<String> getSkillsByAppId(Integer applicantId) {
		return skillMapper.getSkillsByAppId(applicantId);
	}
	
	@Override
	public List<Skill> getAllSkills(){
		return skillMapper.getAllSkills();
	}
	
	@Override
	public List<String> getAllSkillsId(){
		return skillMapper.getAllSkillsId();
	}
	
	@Override
	public int updateSkillsByApplicantId(Integer applicantId, List<String> skills){
		skillMapper.deleteByApplicantId(applicantId);
		if(skills.size() != 0){
			for(String skill: skills){
				if(skill != null && !skill.trim().isEmpty()) {
					skillMapper.insertApplicantSkill(applicantId, skill);
				}
			}
			
			return 1;
		}else{
			
			return 1;
		}
	}

	

}
