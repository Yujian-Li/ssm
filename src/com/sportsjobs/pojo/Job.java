package com.sportsjobs.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Job implements Serializable{
	private Integer jobId;
	private Integer enterpriseId;
	private String jobSpec;
	private String contact;
	private String monthlySalaryId;
	private String jobTypeId;
	private String locationId;
	private String monthlySalary;
	private String jobType;
	private String location;
	private Integer start;
	private Integer rows;
	public String getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(String monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getJobSpec() {
		return jobSpec;
	}
	public void setJobSpec(String jobSpec) {
		this.jobSpec = jobSpec;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getMonthlySalaryId() {
		return monthlySalaryId;
	}
	public void setMonthlySalaryId(String monthlySalaryId) {
		this.monthlySalaryId = monthlySalaryId;
	}
	public String getJobTypeId() {
		return jobTypeId;
	}
	public void setJobTypeId(String jobTypeId) {
		this.jobTypeId = jobTypeId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}

}
