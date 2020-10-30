package com.sportsjobs.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sportsjobs.mapper.JobMapper;
import com.sportsjobs.pojo.Job;
import com.sportsjobs.service.JobService;
import com.sportsjobs.utils.Page;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobMapper jobMapper;

	@Override
	public List<Job> getJobsByEnterpriseId(Integer enterpriseId) {
		return jobMapper.getJobsByEnterpriseId(enterpriseId);
	}

	@Override
	public int isDelJob(Integer jobId) {
		return jobMapper.isDelJob(jobId);
	}

	@Override
	public Page<Job> findJobList(Integer page, Integer rows,
			String jobSpec, String jobType, String locationType,
			String salaryType) {
		Job job = new Job();
		//判断职位描述
		if(StringUtils.isNotBlank(jobSpec)){
			job.setJobSpec(jobSpec);
		}
		//判断职位类别
		if(StringUtils.isNotBlank(jobType)){
			job.setJobType(jobType);
		}
		//判断地点
		if(StringUtils.isNotBlank(locationType)){
			job.setLocation(locationType);
		}
		//判断薪资
		if(StringUtils.isNotBlank(salaryType)){
			job.setMonthlySalary(salaryType);
		}
		//当前页
		job.setStart((page-1) * rows) ;
		//每页数
		job.setRows(rows);
		//查询职位列表
		List<Job> jobs = jobMapper.selectJobList(job);
		//查询总记录数
		Integer count = jobMapper.selectJobListCount(job);
		//创建Page返回对象
		Page<Job> result = new Page<>();
		result.setPage(page);
		result.setRows(jobs);
		result.setSize(rows);
		result.setTotal(count);
		return result;


	}


}
