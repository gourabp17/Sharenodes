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
import org.springframework.web.bind.annotation.ResponseBody;

import com.cportal.database.controller.DatabaseController;
import com.cportal.model.EditUser;
import com.cportal.model.User;
import com.cportal.ui.model.CompanyBroadcast;

@Controller
public class HomeController {

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homeAuthorization(HttpSession session) {
		String homeJsp = null;
		homeJsp = session.getAttribute("userRole")+"/home";
		return homeJsp;
	}

	@RequestMapping(value = { "/superUser/noOfEmployees" }, method = RequestMethod.POST)
	public @ResponseBody String noOfEmployees() {
		// proceed if session of role is superuser
		return "201";
	}

	@RequestMapping(value = { "/superUser/addNewUser" }, method = RequestMethod.POST)
	public @ResponseBody String addNewUser(
			@ModelAttribute("adduser") EditUser editUser, ModelMap model) {
		System.out.println("edituser: " + editUser.getPersonDesignation());

		return "success";

	}

	@RequestMapping(value = { "/superUser/deleteBySuperUser" }, method = RequestMethod.POST)
	public @ResponseBody String deleteBySuperUser(@RequestBody String searchIn) {
		// input comes as "email=farji@farji.com" split with = and use
		System.out.println(searchIn);

		return "success";

	}

	@RequestMapping(value = { "/superUser/editBySuperUser" }, method = RequestMethod.POST)
	public @ResponseBody String editBySuperUser(@RequestBody String searchIn) {

		// input comes as "email=farji@farji.com" split with = and use
		System.out.println(searchIn);
		return "20";// return string in json format eg {Name:Gourab;
					// Manager:man@comp.com; Role:Dev; Designation:Hr} else
					// return not-found
	}

	@RequestMapping(value = { "/superUser/sendToUpdate" }, method = RequestMethod.POST)
	public @ResponseBody String sendToUpdate(
			@ModelAttribute("sendToUpdate") EditUser editUser, ModelMap model) {
		System.out.println("edituser: " + editUser.getPersonDesignation());

		return "success";

	}

	@RequestMapping(value = { "/superUser/listOfUser" }, method = RequestMethod.POST)
	public @ResponseBody String listOfUser(@RequestBody String boundary) {

		// input comes as "count=1-10" split with = and use
		System.out.println(boundary);
		JSONObject obj = new JSONObject();

		obj.put("Name", "Gourab");
		obj.put("Email", "abc@gmail.com");
		obj.put("Manager", "man@comp.com");
		obj.put("Role", "Dev");
		obj.put("Designation", "desc");
		obj.put("Status", "stat");
		JSONObject mergedJson = new JSONObject();
		mergedJson.put("1", obj);
		mergedJson.put("2", obj);
		return mergedJson.toString();
		// return not-found
	}
}
