package com.cportal.webinit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LinkRole implements HandlerInterceptor  {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		HttpSession sess = request.getSession();
	    String requestURI = request.getRequestURI();
	    System.out.println("userrole "+sess.getAttribute("userRole"));
	    System.out.println("url split "+requestURI.split("/")[0]);
		if (sess.getAttribute("userRole") == requestURI.split("/")[0]) {
			return true;
		}
		else{
			response.sendRedirect("");
			return false;
		}
		
	}

}
