package com.sportsjobs.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;








import com.sportsjobs.pojo.Application;
import com.sportsjobs.pojo.BaseDict;
import com.sportsjobs.pojo.Job;
import com.sportsjobs.service.ApplicationService;
import com.sportsjobs.service.BaseDictService;
import com.sportsjobs.service.JobService;
import com.sportsjobs.utils.Page;


@Controller
public class JobController {
	
	@Autowired
	private JobService jobService;
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private ApplicationService applicationService;
	@Value("${job.type}")
	private String JOB_TYPE;
	@Value("${location.type}")
	private String LOCATION_TYPE;
	@Value("${salary.type}")
	private String SALARY_TYPE;
	
	
	@RequestMapping(value = "/jobs")
	public String showJob() {
		return "redirect:/jobs/list.action";
	}	
	
	@RequestMapping(value = "/jobs/list")
	public String list(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows, 
			String jobSpec, String jobType,	String location, String monthlySalary, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		
		 try {
	            request.setCharacterEncoding("UTF-8");
	            response.setContentType("text/html; charset=utf-8");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
		 try {
			String jobS = new String(request.getParameter("jobSpec").getBytes("ISO-8859-1"),"UTF-8");
			//String jobS = new String(request.getParameter("jobSpec"));
			jobSpec = jobS;
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<Job> jobs = jobService.findJobList(page, rows, jobSpec, jobType, location, monthlySalary);
		model.addAttribute("page", jobs);
		//
		List<BaseDict> jobTypee = baseDictService.findBaseDictListByType(JOB_TYPE);
		//
		List<BaseDict> locationTypee = baseDictService.findBaseDictListByType(LOCATION_TYPE);
		//
		List<BaseDict> salaryTypee = baseDictService.findBaseDictListByType(SALARY_TYPE);
		model.addAttribute("jobTypee", jobTypee);
		model.addAttribute("locationTypee", locationTypee);
		model.addAttribute("salaryTypee", salaryTypee);
		//
		model.addAttribute("jobSpec", jobSpec);
		model.addAttribute("jobType", jobType);
		model.addAttribute("locationType", location);
		model.addAttribute("salaryType", monthlySalary);
		return "jobs";
	}
	
	@RequestMapping(value = "/jobs/job/{jobId}")
	public ModelAndView jobApply(@PathVariable("jobId") String jobId) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/jobapply");
		model.addObject("jobId",jobId);

		return model;
	}
	
	@RequestMapping(value = "/jobs/job/job", method = RequestMethod.POST)
	public String isAddApplication(
			@RequestParam(value = "jobId", required = false) Integer jobId,
			@RequestParam(value = "applicantId", required = false) Integer applicantId) {

			Application app = new Application();
			app.setApplicantId(applicantId);
			app.setJobId(jobId);
			int row = applicationService.isAddApplication(app);

		return "redirect:/jobs";
	}
	
}
