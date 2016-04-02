package com.cportal.web.controller;

import java.util.Calendar;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cportal.database.controller.DBSuperUserFunc;
import com.cportal.database.controller.DatabaseController;
import com.cportal.model.EditUser;
import com.cportal.model.User;
import com.cportal.ui.model.CompanyBroadcast;

@Controller
public class HomeController {

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homeAuthorization(HttpSession session) {
		String homeJsp = null;
		homeJsp = session.getAttribute("userRole") + "/home";
		return homeJsp;
	}

	@RequestMapping(value = { "/superUser/noOfEmployees" }, method = RequestMethod.POST)
	public @ResponseBody String noOfEmployees(HttpSession sess) {
		int noUser = new DBSuperUserFunc().noOfUser(sess.getAttribute("cname").toString());
		return String.valueOf(noUser);
	}

	@RequestMapping(value = { "/superUser/addNewUser" }, method = RequestMethod.POST)
	public @ResponseBody String addNewUser(@ModelAttribute("adduser") EditUser editUser, HttpSession session) {
		if ((new DBSuperUserFunc()).companyNewUser(editUser, session.getAttribute("userEmail").toString())) {
			return "success";
		} else {
			return "Company Already Register";
		}

	}

	@RequestMapping(value = { "/superUser/deleteBySuperUser" }, method = RequestMethod.POST)
	public @ResponseBody String deleteBySuperUser(@RequestBody String searchIn) {
		// input comes as "email=farji@farji.com" split with = and use
		System.out.println(searchIn);

		return "success";

	}

	@RequestMapping(value = { "/superUser/editBySuperUser" }, method = RequestMethod.POST)
	public @ResponseBody String editBySuperUser(@RequestParam("email") String email, HttpSession session) {
		JSONObject userJson = new DBSuperUserFunc().searchUser(email, session.getAttribute("cname").toString());
		System.out.println(userJson);
		if (userJson == null) {
			return "not found";
		} else {
			return userJson.toString();
		}

	}

	@RequestMapping(value = { "/superUser/sendToUpdate" }, method = RequestMethod.POST)
	public @ResponseBody String sendToUpdate(@ModelAttribute("sendToUpdate") EditUser editUser, ModelMap model) {
		System.out.println("edituser: " + editUser.getPersonDesignation());

		return "success";

	}

	@RequestMapping(value = { "/superUser/listOfUser" }, method = RequestMethod.GET)
	public @ResponseBody String listOfUser(@RequestParam("start") String start, @RequestParam("end") String end,
			HttpSession sess) {
		JSONObject listOfUserJson = new DBSuperUserFunc().listOfUser(sess.getAttribute("cname").toString(), start, end);
		if (listOfUserJson == null) {
			return "not found";
		} else {
			return listOfUserJson.toString();
		}
		// return not-found
	}
}
