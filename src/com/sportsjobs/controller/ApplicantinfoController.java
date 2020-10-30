package com.sportsjobs.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sportsjobs.mapper.SkillMapper;
import com.sportsjobs.pojo.Applicantinfo;
import com.sportsjobs.pojo.Job;
import com.sportsjobs.pojo.Skill;
import com.sportsjobs.service.ApplicantinfoService;
import com.sportsjobs.service.ApplicationService;
import com.sportsjobs.service.SkillService;


/**
 * @author liyuj
 *
 */
@Controller
public class ApplicantinfoController {
	
	@Autowired
	private ApplicantinfoService applicantinfoService;
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private ApplicationService applicationService;
	
	private Logger logger = Logger.getLogger(ApplicantinfoController.class);
	
	@RequestMapping(value="/applicantlogin", method=RequestMethod.POST)
	public ModelAndView applicantlogin(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String applicantAccount = request.getParameter("applicantAccount");
		String pwd = request.getParameter("applicantPwd");
		Applicantinfo a = applicantinfoService.getApplicantByNameAndPwd(applicantAccount);
		logger.info("求职者 "+a+" 有效登录");
		if(a == null || !pwd.equals(a.getApplicantPwd())){
			
			return new ModelAndView("applicantlogin");
		}else{
		mv.setViewName("applicantaccount");
		mv.addObject("success","success");
		mv.addObject("applicant",a);
		List<Skill> skills = skillService.getSkillsByApplicantId(a.getApplicantId());
		mv.addObject("skills", skills);
		List<Job> jobs = applicationService.getAppsByApplicantId(a.getApplicantId());
		mv.addObject("apps", jobs);
		
		return mv;}
	}
	
	@RequestMapping("/applicants")
	public ModelAndView getApplicants(@RequestParam(value = "applicantId", required = false) Integer applicantId,
			@RequestParam(value="startPage", required=false, defaultValue="1") Integer startPage,
			@RequestParam(value="pageShow", required=false, defaultValue="10") Integer pageShow ) {
		logger.info("获取求职者集合  startPage="+startPage+", pageShow="+pageShow);
		ModelAndView model = new ModelAndView();
		model.setViewName("applicants");

		//查询条件处理
		Applicantinfo applicant = new Applicantinfo();
		if (applicantId != null)
			applicant.setApplicantId(applicantId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		//计算当前查询起始数据索引
		int startIndex = (startPage-1) * pageShow;
		map.put("applicant", applicant);
		map.put("startIndex", startIndex);
		map.put("pageShow", pageShow);
		List<Applicantinfo> applicants = applicantinfoService.getApplicants(map);
		model.addObject("applicants", applicants);
		
		//获取总量
		int applicantTotal = applicantinfoService.getApplicantTotal();
		//计算总页数
		int pageTotal = 1;
		if (applicantTotal % pageShow == 0)
			pageTotal = applicantTotal / pageShow;
		else
			pageTotal = applicantTotal / pageShow + 1;			
		model.addObject("pageTotal", pageTotal);
		model.addObject("pageNow", startPage);

		return model;
	}
	
	/**
	 * 根据编号获取求职者信息
	 * @param applicantId
	 * @return
	 */
	@RequestMapping("/applicant/{applicantId}")
	public ModelAndView getApplicantById(@PathVariable("applicantId") Integer applicantId) {
		logger.info("获取求职者 " + applicantId);
		ModelAndView model = new ModelAndView();
		model.setViewName("/applicantedit");

		Applicantinfo applicant = applicantinfoService.getApplicantById(applicantId);
		model.addObject("applicant", applicant);

		return model;
	}
	

	/**
	 * 添加/修改求职者信息
	 * @param applicantId
	 * @param isUpdate 操作标识
	 * @param applicantName
	 * @param applicantGender
	 * @param applicantAccount
	 * @param applicantPwd
	 * @return
	 */
	@RequestMapping(value = "/applicant/applicant", method = RequestMethod.POST)
	public String isUpdateOrAddApplicant(
			@RequestParam(value = "applicantId", required = false) Integer applicantId,
			@RequestParam(value = "isupdate", required = false) Integer isUpdate,
			@RequestParam(value = "applicantName", required = false) String applicantName,
			@RequestParam(value = "applicantGender", required = false) String applicantGender,
			@RequestParam("applicantAccount") String applicantAccount,
			@RequestParam("applicantPwd") String applicantPwd) {

		Applicantinfo applicant = new Applicantinfo();
			applicant.setApplicantId(applicantId);
			applicant.setApplicantName(applicantName);
			applicant.setApplicantGender(applicantGender);
			applicant.setApplicantAccount(applicantAccount);
			applicant.setApplicantPwd(applicantPwd);

		if (isUpdate != null) {
			logger.info("修改求职者 " + applicant + " 的信息");
			int row = applicantinfoService.isUpdateApplicant(applicant);
		} else {
			logger.info("添加求职者 " + applicant + " 的信息");
			int row = applicantinfoService.isAddApplicant(applicant);
		}

		return "redirect:/applicants";
	}
	
	/**
	 * 删除求职者
	 * @param applicantId
	 * @return
	 */
	@RequestMapping(value = "/applicant/{applicantId}", method = RequestMethod.DELETE)
	public String isDelApplicant(@PathVariable("applicantId") Integer applicantId) {
		logger.info("删除求职者 " + applicantId);

		int row = applicantinfoService.isDelApplicant(applicantId);

		return "redirect:/applicants";
	}
	
	
	/**
	 * 根据编号获取求职者技能
	 * @param applicantId
	 * @return
	 */
	@RequestMapping(value = "/applicantSkills/{applicantId}", method = RequestMethod.GET)
	public ModelAndView getSkillsByApplicantId(@PathVariable("applicantId") Integer applicantId) {
		ModelAndView mv = new ModelAndView();
		System.out.println(applicantId);
		
		mv.setViewName("/skillsedit");
		
		List<Skill> allSkills = skillService.getAllSkills();
		mv.addObject("allSkills", allSkills);
		
	    List<Skill> skills = skillService.getSkillsByApplicantId(applicantId);
		List<String> skillsId = skills.stream().map(item -> item.getSkillId()).collect(Collectors.toList());
		
		Applicantinfo applicant = applicantinfoService.getApplicantById(applicantId);
		applicant.setSkillsId(skillsId);
		mv.addObject("applicant", applicant);
		
		return mv;
	}
	
	@RequestMapping(value = "/applicantSkills/applicantSkills", method = RequestMethod.POST)
	public String isUpdateApplicant(
			@RequestParam(value = "applicantId", required = false) Integer applicantId,
			@RequestParam(value = "skills", required = false) String skills,
			@RequestParam(value = "isupdate", required = false) Integer isUpdate){
		if(isUpdate != null){
			skillService.updateSkillsByApplicantId(applicantId, Arrays.asList(skills.split(",")));
		}
		
		return "redirect:/applicants";
		
	}
	
	
	@RequestMapping(value = "/skillsedit", method = RequestMethod.GET)
	public String getSkillsList(Model model) {
		List<String> skillsList = new ArrayList<String>();
		skillsList.add("经纪人工作相关经验");
		skillsList.add("经纪人证书");
		skillsList.add("市场营销谈判");
		skillsList.add("产品市场营销策划");
		skillsList.add("赛事策划案书写");
		skillsList.add("室内赛事运营");
		skillsList.add("户外赛事运营");
		skillsList.add("场馆运营");
		skillsList.add("场馆前台工作经验");
		skillsList.add("MS Office");
		skillsList.add("Photoshop");
		skillsList.add("英语六级");
		model.addAttribute("skillsList",skillsList);
		
		Applicantinfo applicant = new Applicantinfo();
		model.addAttribute("applicant",applicant);
		return "skillsedit";
	}
	
	@RequestMapping(value = "/skillsedit", method = RequestMethod.POST)
	public String isUpdateSkills(Model model, Applicantinfo applicant){
		model.addAttribute("skills", applicant.getSkills());
		/*预计不能加载因为applicant的数据丢啦*/
		return "redirect:/applicantaccount";
	}
	
}
