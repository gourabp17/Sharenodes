package com.cportal.webinit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cportal.config.ConfigDB;

public class LoggingInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession sess = request.getSession();
		System.out.println(sess.getAttribute("succesfullogin"));
		if (sess.getAttribute("succesfullogin") == null) {
			response.sendRedirect("index");
			;
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView == null)
			return;
		modelAndView.addObject("baseurl", ConfigDB.retrnConf().getBASEURL());
		System.out.println("---Request Completed---" + ConfigDB.getBASEURL());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// System.out.println("---Request Completed---");
	}
}