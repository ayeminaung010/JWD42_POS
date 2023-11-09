package com.ai.jwd42.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.jwd42.dto.Category;
import com.ai.jwd42.dto.User;

@Controller
public class CategoryControlller {

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView category(HttpServletRequest request, ModelMap model) {
		Category category = new Category();
		return new ModelAndView("admin/category/index.html","category", category);
	}
	
	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public ModelAndView addCategory(HttpServletRequest request, ModelMap model) {
		Category category = new Category();
		return new ModelAndView("admin/category/add.html","category", category);
	}
}
