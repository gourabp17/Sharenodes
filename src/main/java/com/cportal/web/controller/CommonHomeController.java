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

@Controller
public class CommonHomeController {

	@RequestMapping(value = { "/buddy" }, method = RequestMethod.GET)
	public String buddy() {
		return "general/buddy";
	}

}
