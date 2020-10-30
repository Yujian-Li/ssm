package com.sportsjobs.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportsjobs.pojo.Job;
import com.sportsjobs.utils.Page;

@Repository
public interface JobMapper {
	
	List<Job> getJobsByEnterpriseId(Integer enterpriseId);

	int isDelJob(Integer jobId);

	List<Job> selectJobList(Job job);

	Integer selectJobListCount(Job job);

}
