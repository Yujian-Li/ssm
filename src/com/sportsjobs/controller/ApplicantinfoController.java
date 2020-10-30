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
		logger.info("��ְ�� "+a+" ��Ч��¼");
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
		logger.info("��ȡ��ְ�߼���  startPage="+startPage+", pageShow="+pageShow);
		ModelAndView model = new ModelAndView();
		model.setViewName("applicants");

		//��ѯ��������
		Applicantinfo applicant = new Applicantinfo();
		if (applicantId != null)
			applicant.setApplicantId(applicantId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		//���㵱ǰ��ѯ��ʼ��������
		int startIndex = (startPage-1) * pageShow;
		map.put("applicant", applicant);
		map.put("startIndex", startIndex);
		map.put("pageShow", pageShow);
		List<Applicantinfo> applicants = applicantinfoService.getApplicants(map);
		model.addObject("applicants", applicants);
		
		//��ȡ����
		int applicantTotal = applicantinfoService.getApplicantTotal();
		//������ҳ��
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
	 * ���ݱ�Ż�ȡ��ְ����Ϣ
	 * @param applicantId
	 * @return
	 */
	@RequestMapping("/applicant/{applicantId}")
	public ModelAndView getApplicantById(@PathVariable("applicantId") Integer applicantId) {
		logger.info("��ȡ��ְ�� " + applicantId);
		ModelAndView model = new ModelAndView();
		model.setViewName("/applicantedit");

		Applicantinfo applicant = applicantinfoService.getApplicantById(applicantId);
		model.addObject("applicant", applicant);

		return model;
	}
	

	/**
	 * ���/�޸���ְ����Ϣ
	 * @param applicantId
	 * @param isUpdate ������ʶ
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
			logger.info("�޸���ְ�� " + applicant + " ����Ϣ");
			int row = applicantinfoService.isUpdateApplicant(applicant);
		} else {
			logger.info("�����ְ�� " + applicant + " ����Ϣ");
			int row = applicantinfoService.isAddApplicant(applicant);
		}

		return "redirect:/applicants";
	}
	
	/**
	 * ɾ����ְ��
	 * @param applicantId
	 * @return
	 */
	@RequestMapping(value = "/applicant/{applicantId}", method = RequestMethod.DELETE)
	public String isDelApplicant(@PathVariable("applicantId") Integer applicantId) {
		logger.info("ɾ����ְ�� " + applicantId);

		int row = applicantinfoService.isDelApplicant(applicantId);

		return "redirect:/applicants";
	}
	
	
	/**
	 * ���ݱ�Ż�ȡ��ְ�߼���
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
		skillsList.add("�����˹�����ؾ���");
		skillsList.add("������֤��");
		skillsList.add("�г�Ӫ��̸��");
		skillsList.add("��Ʒ�г�Ӫ���߻�");
		skillsList.add("���²߻�����д");
		skillsList.add("����������Ӫ");
		skillsList.add("����������Ӫ");
		skillsList.add("������Ӫ");
		skillsList.add("����ǰ̨��������");
		skillsList.add("MS Office");
		skillsList.add("Photoshop");
		skillsList.add("Ӣ������");
		model.addAttribute("skillsList",skillsList);
		
		Applicantinfo applicant = new Applicantinfo();
		model.addAttribute("applicant",applicant);
		return "skillsedit";
	}
	
	@RequestMapping(value = "/skillsedit", method = RequestMethod.POST)
	public String isUpdateSkills(Model model, Applicantinfo applicant){
		model.addAttribute("skills", applicant.getSkills());
		/*Ԥ�Ʋ��ܼ�����Ϊapplicant�����ݶ���*/
		return "redirect:/applicantaccount";
	}
	
}
