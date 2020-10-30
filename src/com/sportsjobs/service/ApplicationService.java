package com.sportsjobs.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.Application;
import com.sportsjobs.pojo.Job;


@Repository
public interface ApplicationService {
	
	public int isAddApplication(Application app);
	
	public List<Application> getAppsByEnterpriseId(Integer enterpriseId);

	public List<Job> getAppsByApplicantId(Integer applicantId);

}
