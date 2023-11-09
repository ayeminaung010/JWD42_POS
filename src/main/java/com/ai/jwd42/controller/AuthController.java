package com.ai.jwd42.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.jwd42.dto.User;

@Controller
public class AuthController {
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, ModelMap model) {
		User user = new User();
		return new ModelAndView("login.html", "user", user);
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signUp(HttpServletRequest request, ModelMap model) {
		User user = new User();
		return new ModelAndView("signup.html", "user", user);
	}
}
