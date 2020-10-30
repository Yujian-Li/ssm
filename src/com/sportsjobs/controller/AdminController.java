package com.sportsjobs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	private Logger logger = Logger.getLogger(AdminController.class);
	
	@RequestMapping(value="/adminlogin", method=RequestMethod.POST)
	public ModelAndView adminlogin(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String adminAccount = request.getParameter("adminAccount");
		String pwd = request.getParameter("adminPwd");
		logger.info("管理员有效登录");
		if(!adminAccount.equals("admin")|| !pwd.equals("admin")){
			
			return new ModelAndView("adminlogin");
		}else{
		mv.setViewName("adminaccount");
		mv.addObject("success","登录成功");		
		return mv;
		}
	}
	
	@RequestMapping(value = "/back")
	public ModelAndView backTo(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminaccount");
		return mv;
		
	}

}
