package com.sportsjobs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sportsjobs.pojo.Applicantinfo;
import com.sportsjobs.pojo.Application;
import com.sportsjobs.pojo.Enterprise;
import com.sportsjobs.pojo.Job;
import com.sportsjobs.pojo.Skill;
import com.sportsjobs.service.ApplicationService;
import com.sportsjobs.service.EnterpriseService;
import com.sportsjobs.service.JobService;

@Controller
public class EnterpriseController {
	
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private JobService jobService;
	@Autowired
	private ApplicationService applicationService;

	private Logger logger = Logger.getLogger(EnterpriseController.class);	
	
	@RequestMapping("/enterprises")
	public ModelAndView getEnterprises(@RequestParam(value = "enterpriseId", required = false) Integer enterpriseId,
			@RequestParam(value="startPage", required=false, defaultValue="1") Integer startPage,
			@RequestParam(value="pageShow", required=false, defaultValue="10") Integer pageShow ) {
		logger.info("��ȡ��ְ�߼���  startPage="+startPage+", pageShow="+pageShow);
		ModelAndView model = new ModelAndView();
		model.setViewName("enterprises");

		//��ѯ��������
		Enterprise enterprise = new Enterprise();
		if (enterpriseId != null)
			enterprise.setEnterpriseId(enterpriseId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		//���㵱ǰ��ѯ��ʼ��������
		int startIndex = (startPage-1) * pageShow;
		map.put("enterprise", enterprise);
		map.put("startIndex", startIndex);
		map.put("pageShow", pageShow);
		List<Enterprise> enterprises = enterpriseService.getEnterprises(map);
		model.addObject("enterprises", enterprises);
		
		//��ȡ��ҵ����
		int enterpriseTotal = enterpriseService.getEnterpriseTotal();
		//������ҳ��
		int pageTotal = 1;
		if (enterpriseTotal % pageShow == 0)
			pageTotal = enterpriseTotal / pageShow;
		else
			pageTotal = enterpriseTotal / pageShow + 1;			
		model.addObject("pageTotal", pageTotal);
		model.addObject("pageNow", startPage);

		return model;
	}
	
	/**
	 * ���ݱ�Ż�ȡ��ҵ��Ϣ
	 * @param enterpriseId
	 * @return
	 */
	@RequestMapping("/enterprise/{enterpriseId}")
	public ModelAndView getEnterpriseById(@PathVariable("enterpriseId") Integer enterpriseId) {
		logger.info("��ȡ��ҵ " + enterpriseId);
		ModelAndView model = new ModelAndView();
		model.setViewName("/enterpriseedit");

		Enterprise enterprise = enterpriseService.getEnterpriseById(enterpriseId);
		model.addObject("enterprise", enterprise);

		return model;
	}
	

	/**
	 * ���/�޸���ҵ��Ϣ
	 * @param enterpriseId
	 * @param isUpdate ������ʶ
	 * @param enterpriseName
	 * @param enterpSpec
	 * @param enterpriseAccount
	 * @param enterprisePwd
	 * @return
	 */
	@RequestMapping(value = "/enterprise/enterprise", method = RequestMethod.POST)
	public String isUpdateOrAddApplicant(
			@RequestParam(value = "enterpriseId", required = false) Integer enterpriseId,
			@RequestParam(value = "isupdate", required = false) Integer isUpdate,
			@RequestParam(value = "enterpriseName", required = false) String enterpriseName,
			@RequestParam(value = "enterpriseSpec", required = false) String enterpriseSpec,
			@RequestParam("enterpriseAccount") String enterpriseAccount,
			@RequestParam("enterprisePwd") String enterprisePwd) {

		Enterprise enterprise = new Enterprise();
		    enterprise.setEnterpriseId(enterpriseId);
		    enterprise.setEnterpriseName(enterpriseName);
		    enterprise.setEnterpriseSpec(enterpriseSpec);
		    enterprise.setEnterpriseAccount(enterpriseAccount);
		    enterprise.setEnterprisePwd(enterprisePwd);

		if (isUpdate != null) {
			logger.info("�޸���ҵ " + enterprise + " ����Ϣ");
			int row = enterpriseService.isUpdateEnterprise(enterprise);
		} else {
			logger.info("�����ҵ " + enterprise + " ����Ϣ");
			int row = enterpriseService.isAddEnterprise(enterprise);
		}

		return "redirect:/enterprises";
	}
	
	/**
	 * ɾ����ҵ
	 * @param enterpriseId
	 * @return
	 */
	@RequestMapping(value = "/enterprise/{enterpriseId}", method = RequestMethod.DELETE)
	public String isDelEnterprise(@PathVariable("enterpriseId") Integer enterpriseId) {
		logger.info("ɾ����ҵ " + enterpriseId);

		int row = enterpriseService.isDelEnterprise(enterpriseId);

		return "redirect:/enterprises";
	}
	
	@RequestMapping(value="/enterpriselogin", method=RequestMethod.POST)
	public ModelAndView enterpriselogin(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String enterpriseAccount = request.getParameter("enterpriseAccount");
		String pwd = request.getParameter("enterprisePwd");
		Enterprise e = enterpriseService.getEnterpriseByName(enterpriseAccount);
		logger.info("��ְ�� "+e+" ��Ч��¼");
		if(e == null || !pwd.equals(e.getEnterprisePwd())){
			
			return new ModelAndView("enterpriselogin");
		}else{

		mv.setViewName("enterpriseaccount");
		mv.addObject("success","��¼�ɹ�");
		mv.addObject("enterprise",e);
		List<Job> jobs = jobService.getJobsByEnterpriseId(e.getEnterpriseId());
		mv.addObject("jobs", jobs);
		List<Application> apps = applicationService.getAppsByEnterpriseId(e.getEnterpriseId());
		mv.addObject("apps",apps);
		return mv;}
	}
	
	@RequestMapping(value = "/enterpriseJob/{jobId}", method = RequestMethod.DELETE)
	public String isDelJob(@PathVariable("jobId") Integer jobId){
		
		logger.info("ɾ��ְλ " + jobId);
		int row = jobService.isDelJob(jobId);
		
		return "redirect:/enterpriseaccount";		
	}
}
