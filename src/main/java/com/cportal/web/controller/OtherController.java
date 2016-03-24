package com.cportal.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cportal.ui.model.CompanyBroadcast;

@Controller
public class OtherController {
	@RequestMapping(value = { "/news" }, method = RequestMethod.GET)
	public String news(ModelMap companybroadcast,HttpSession session) {
		CompanyBroadcast cmpnybrd= new CompanyBroadcast();
		companybroadcast.addAttribute("broadcast", cmpnybrd.getList());
		session.setAttribute("userRole", "hr");
		String homeJsp = null;
		homeJsp = "general/companyNews";
		return homeJsp;
	}
}
