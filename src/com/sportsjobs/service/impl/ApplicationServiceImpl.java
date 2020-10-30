package com.sportsjobs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsjobs.mapper.ApplicationMapper;
import com.sportsjobs.pojo.Application;
import com.sportsjobs.pojo.Job;
import com.sportsjobs.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	private ApplicationMapper applicationMapper;

	@Override
	public int isAddApplication(Application app) {
		return applicationMapper.isAddApplication(app);
	}

	@Override
	public List<Application> getAppsByEnterpriseId(Integer enterpriseId) {
		return applicationMapper.getAppsByEnterpriseId(enterpriseId);
	}

	@Override
	public List<Job> getAppsByApplicantId(Integer applicantId) {
		return applicationMapper.getAppsByApplicantId(applicantId);
	}

}
