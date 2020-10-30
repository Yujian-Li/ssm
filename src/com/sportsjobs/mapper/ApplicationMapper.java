package com.sportsjobs.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.Application;
import com.sportsjobs.pojo.Job;

@Repository
public interface ApplicationMapper {
	 
	int isAddApplication(Application app);

	List<Application> getAppsByEnterpriseId(Integer enterpriseId);

	List<Job> getAppsByApplicantId(Integer applicantId);

}
