package com.ai.jwd42.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.jwd42.dto.Category;
import com.ai.jwd42.dto.SubCategory;
import com.ai.jwd42.service.CategoryService;
import com.ai.jwd42.service.SubCategoryService;

@Controller

public class SubCategoryController {
	@Autowired
	private SubCategoryService subcategoryservice;
	private CategoryService categoryservice;
	
	@RequestMapping(value = "/sub-category", method = RequestMethod.GET)
	public ModelAndView subCategory(HttpServletRequest request, ModelMap model) {
		List<SubCategory> subcategories = subcategoryservice.findAll();
		return new ModelAndView("admin/subCategory/index.html","subcategories", subcategories);
	}
	
	@RequestMapping(value = "/sub-category/add", method = RequestMethod.GET)
	public ModelAndView addsubCategory(ModelMap model) {
		SubCategory subcategory = new SubCategory();
		return new ModelAndView("admin/subCategory/add.html","subcategory", subcategory);
	}
	@RequestMapping(value = "/sub-category/add", method = RequestMethod.POST)
	public ModelAndView CreatsubCategory(@ModelAttribute SubCategory subCategory, ModelMap model, HttpServletRequest request) {
		SubCategory subcategory = new SubCategory();
		List<Category> categories = categoryservice.findAll();
		request.setAttribute("categories", categories);
		return new ModelAndView("admin/subCategory/add.html","subcategory", subcategory);
		
	}
}
