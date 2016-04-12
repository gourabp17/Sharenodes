package com.cportal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HrController {
	@RequestMapping(value = { "/hr/leavePolicy" }, method = RequestMethod.GET)
	public String leavepolicies() {
		return "hr/leavepolicy";
	}
	@RequestMapping(value = { "/hr/saveHoliday" }, method = RequestMethod.POST)
	public @ResponseBody String saveHoliday(@RequestParam("holidaylist") String holidaylist) {
		System.out.println(holidaylist);
		return "updated";
	}
}
