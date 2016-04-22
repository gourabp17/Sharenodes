package com.cportal.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cportal.database.controller.DBHrFunc;
import com.cportal.database.controller.DBSuperUserFunc;
import com.cportal.model.LeavePolicy;
@Controller
public class HrController {
	@RequestMapping(value = { "/hr/leavePolicy" }, method = RequestMethod.GET)
	public String leavepolicies() {
		return "hr/leavepolicy";
	}
	@RequestMapping(value = { "/hr/saveHoliday" }, method = RequestMethod.POST)
	public @ResponseBody String saveHoliday(@RequestParam("holidaylist") String holidaylist,
			@RequestParam("leave_unit") String leave_unit,@RequestParam("sl") String sl,
			@RequestParam("cl") String cl,@RequestParam("el") String el, HttpSession session) {
		LeavePolicy lp= new LeavePolicy();
		lp.setcEmail(session.getAttribute("userEmail").toString());
		lp.setcName(session.getAttribute("cname").toString());
		lp.setHolidaylist(holidaylist);
		lp.setLeave_unit(leave_unit);
		lp.setSl(sl);
		lp.setCl(cl);
		lp.setEl(el);
		lp.setCurrent_year();
		if ((new DBHrFunc()).updateHoliday(lp)) {
			return "success";
		} else {
			return "Error occured. Try Later";
		}
	}
}
