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
		//�ж�ְλ����
		if(StringUtils.isNotBlank(jobSpec)){
			job.setJobSpec(jobSpec);
		}
		//�ж�ְλ���
		if(StringUtils.isNotBlank(jobType)){
			job.setJobType(jobType);
		}
		//�жϵص�
		if(StringUtils.isNotBlank(locationType)){
			job.setLocation(locationType);
		}
		//�ж�н��
		if(StringUtils.isNotBlank(salaryType)){
			job.setMonthlySalary(salaryType);
		}
		//��ǰҳ
		job.setStart((page-1) * rows) ;
		//ÿҳ��
		job.setRows(rows);
		//��ѯְλ�б�
		List<Job> jobs = jobMapper.selectJobList(job);
		//��ѯ�ܼ�¼��
		Integer count = jobMapper.selectJobListCount(job);
		//����Page���ض���
		Page<Job> result = new Page<>();
		result.setPage(page);
		result.setRows(jobs);
		result.setSize(rows);
		result.setTotal(count);
		return result;


	}


}
