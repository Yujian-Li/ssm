package com.sportsjobs.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.Job;
import com.sportsjobs.utils.Page;

@Repository
public interface JobService {
	
	public List<Job> getJobsByEnterpriseId(Integer enterpriseId);

	public int isDelJob(Integer jobId);

	public Page<Job> findJobList(Integer page, Integer rows,
			String jobSpec, String jobType, String locationType,
			String salaryType);

}
