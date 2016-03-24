package com.cportal.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cportal.database.controller.DatabaseController;
import com.cportal.model.LoginCredential;
import com.cportal.model.LoginUser;
import com.cportal.model.User;
import com.cportal.model.mailservice.MailGun;
import com.cportal.ui.model.GenarateCaptchaImg;

@Controller
public class LoginFromController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String printWelcome(ModelMap model, HttpSession sess) {
		System.out.println(sess.getAttribute("succesfullogin"));
		if (sess.getAttribute("succesfullogin") != null) {
			
			return "redirect:/home";
		}
		return "hello";

	}

	@RequestMapping(value = { "/registercomp" }, method = RequestMethod.POST)
	public @ResponseBody String registerCompany(@ModelAttribute("test") User user, ModelMap model) {

		// user=new User();
		model.addAttribute("test", user);
		if (DatabaseController.companyNewRegistration(user)) {
			return "success";
		} else {
			return "Company Already Register";
		}

	}

	@RequestMapping(value = { "/loginform" }, method = RequestMethod.POST)
	public @ResponseBody String loginCheck(@ModelAttribute("login") LoginUser luser, ModelMap model1,
			HttpSession session) {

		String username ="pradeep";
		String cname ="pradeep";
		String userType = "superuser";
		String email = "farji@farji.com";
		if (email == null || cname == null || userType == null || email == null) {
			String msg = "User id or Password wrong!.";
			model1.addAttribute("login", msg);
			return msg;
		}

		if (email.equals(luser.getUsername())) {
			session.setAttribute("succesfullogin", cname);
			return "success";
		} else {
			return "Some error occured";
		}

	}

	@RequestMapping(value = { "/loginform/generate_captcha" }, method = RequestMethod.GET)
	public @ResponseBody byte[] generateCaptcha(HttpSession session) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String key = uuid.substring(0, 5);
		session.removeAttribute("captcha");
		session.setAttribute("captcha", key);
		String imageBytesgnImg = null;

		GenarateCaptchaImg gnImg = new GenarateCaptchaImg();
		try {
			imageBytesgnImg = gnImg.generateImg(key);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File fi = new File(imageBytesgnImg);
		byte[] fileContent = null;
		try {
			fileContent = Files.readAllBytes(fi.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileContent;
	}

	

	@RequestMapping(value = { "/loginform/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.removeAttribute("succesfullogin");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = { "/loginform/forgetpassword" }, method = RequestMethod.GET)
	public @ResponseBody String forgetPwd(@RequestParam("regemailad") String regemailad) {
		System.out.println("reg mail "+regemailad);
		MailGun mg= new MailGun();
		mg.sendMail(regemailad);
		return "3";

	}
}