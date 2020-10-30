package com.sportsjobs.pojo;

import org.springframework.stereotype.Component;

@Component
public class Skill {
	private String skillId;
	private String skillSpec;
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public String getSkillSpec() {
		return skillSpec;
	}
	public void setSkillSpec(String skillSpec) {
		this.skillSpec = skillSpec;
	}

}
