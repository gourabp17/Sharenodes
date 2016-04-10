package com.cportal.web.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cportal.database.controller.DBSuperUserFunc;
import com.cportal.model.EditUser;
import com.cportal.ui.model.CompanyBroadcast;

@Controller
public class CommonHomeController {

	@RequestMapping(value = { "/buddy" }, method = RequestMethod.GET)
	public String buddy() {
		return "general/buddy";
	}
	@RequestMapping(value = { "/news" }, method = RequestMethod.GET)
	public String news(ModelMap companybroadcast,HttpSession session) {
		CompanyBroadcast cmpnybrd= new CompanyBroadcast();
		companybroadcast.addAttribute("broadcast", cmpnybrd.getList());
		session.setAttribute("userRole", "hr");
		String homeJsp = null;
		homeJsp = "general/companyNews";
		return homeJsp;
	}
	@RequestMapping(value = { "/leaves" }, method = RequestMethod.GET)
	public String leaves() {
		return "general/leaves";
	}
	@RequestMapping(value = { "/payslip" }, method = RequestMethod.GET)
	public String payslip() {
		return "general/payslip";
	}
	@RequestMapping(value = { "/allhours" }, method = RequestMethod.GET)
	public String hours() {
		return "general/allhours";
	}
	@RequestMapping(value = { "/people" }, method = RequestMethod.GET)
	public String people() {
		return "general/people";
	}

}
