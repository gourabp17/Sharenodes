package com.cportal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HrController {
	@RequestMapping(value = { "/hr/leavePolicy" }, method = RequestMethod.GET)
	public String leavepolicies() {
		System.out.println("hr leavaw");
		return "hr/leavepolicy";
	}
}
