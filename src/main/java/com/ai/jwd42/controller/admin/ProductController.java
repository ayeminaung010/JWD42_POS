package com.ai.jwd42.controller.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.jwd42.dto.Product;
import com.ai.jwd42.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView product() {
		Product product = new Product();
		return new ModelAndView("admin/product/index.html","product", product);
	}
	
	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		Product product = new Product();
		
		return new ModelAndView("admin/product/add.html","product", product);
	}
	
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public ModelAndView createProduct(@ModelAttribute Product product,BindingResult result,ModelMap modelMap){
		
		return new ModelAndView("admin/product/add.html","product", product);
	}
	
//	@ModelAttribute("brandList")
//	public List<Brand> getCourses() {
//		List<Brand> brands = brandService.findAll();
//
//		return brands;
//	}
	
//	@ModelAttribute("subCategoryList")
//	public List<SubCategory> getCourses() {
//		List<SubCategory> subCategories = subCategoryService.findAll();
//
//		return subCategories;
//	}
	
}
