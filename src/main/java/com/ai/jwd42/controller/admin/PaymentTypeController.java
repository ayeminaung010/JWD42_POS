package com.ai.jwd42.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.jwd42.dto.User;

@Controller
public class PaymentTypeController {
	@RequestMapping(value = "/payment-type", method = RequestMethod.GET)
	public ModelAndView paymentType(HttpServletRequest request, ModelMap model) {
		User user = new User();
		return new ModelAndView("admin/paymentType/index.html","user", user);
	}
}
