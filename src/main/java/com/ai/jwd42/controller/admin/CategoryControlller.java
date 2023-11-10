package com.ai.jwd42.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.jwd42.dto.Category;
import com.ai.jwd42.service.CategoryService;

@Controller
public class CategoryControlller {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	@Qualifier("categoryValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView category(HttpServletRequest request, ModelMap model) {
		List<Category> categories = categoryService.findAll();
		return new ModelAndView("admin/category/index.html", "categories", categories);
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public String addCategory() {
		return "admin/category/add.html";
	}

	@ModelAttribute("category")
	public Category createCategory() {
		return new Category();
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String createCategory(@ModelAttribute("category") @Validated Category category, BindingResult bindingResult,
			ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "admin/category/add.html";
		}
		System.out.println("category: " + category.getName());
		boolean status = categoryService.addCategory(category);
		if(status) {
			return "redirect:/category";
		}
		return "admin/category/add.html";
	}
}
