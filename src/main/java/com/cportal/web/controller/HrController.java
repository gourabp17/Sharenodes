package com.cportal.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cportal.database.controller.DBHrFunc;
import com.cportal.database.controller.DBSuperUserFunc;
import com.cportal.model.LeavePolicy;

@Controller
public class HrController {
	@RequestMapping(value = { "/hr/leavePolicy" }, method = RequestMethod.GET)
	public ModelAndView  leavepolicies(ModelAndView model,HttpSession sess) {
		LeavePolicy lp=new DBHrFunc().holidayDetails(sess.getAttribute("cname").toString());
		model = new ModelAndView("hr/leavepolicy");
		
		model.addObject("leavePolicy",lp);
		return model;
	}

	@RequestMapping(value = { "/hr/saveHoliday" }, method = RequestMethod.POST)
	public @ResponseBody String saveHoliday(@RequestParam("holidaylist") String holidaylist,
			@RequestParam("leave_unit") String leave_unit, @RequestParam("sl") Double sl, @RequestParam("cl") Double cl,
			@RequestParam("el") Double el, HttpSession session) {
		LeavePolicy lp = new LeavePolicy();
		lp.setcEmail(session.getAttribute("userEmail").toString());
		lp.setcName(session.getAttribute("cname").toString());
		lp.setHolidaylist(holidaylist);
		lp.setLeave_unit(leave_unit);
		if ("Hourly".equals(leave_unit)) {
			lp.setSl((sl != null) ? (sl) : 0);
			lp.setCl((cl != null) ? (cl) : 0);
			lp.setEl((sl != null) ? (el) : 0);
		}
		else if("Monthly".equals(leave_unit)){
			lp.setSl( (sl != null) ? (sl)/30 : 0);
			lp.setCl( (cl != null) ? (cl)/30 : 0);
			lp.setEl( (el != null) ? (el)/30 : 0);
		}
		else if("Yearly".equals(leave_unit)){
			lp.setSl( (sl != null) ? (sl)/365 : 0);
			lp.setCl( (cl != null) ? (cl)/365 : 0);
			lp.setEl( (el != null) ? (el)/365 : 0);
		}
		lp.setCurrent_year();
		
		if ((new DBHrFunc()).updateHoliday(lp)) {
			return "success";
		} else {
			return "Error occured. Try Later";
		}
	}
}
