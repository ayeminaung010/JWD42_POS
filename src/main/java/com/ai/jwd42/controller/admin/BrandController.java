package com.ai.jwd42.controller.admin;

import java.security.KeyStore.Entry.Attribute;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.jwd42.dto.Brand;

import com.ai.jwd42.service.BrandService;

@Controller
public class BrandController {
	@Autowired
	private BrandService brandService;
	Brand brand = new Brand();

	@RequestMapping(value = "/brand", method = RequestMethod.GET)
	public ModelAndView brand(HttpServletRequest request, ModelMap model) {
		model.addAttribute("brands", brandService.findAll());
		return new ModelAndView("admin/brand/index.html", "brand", brand);
	}

	@RequestMapping(value = "/brand/add", method = RequestMethod.GET)
	public ModelAndView addBrand(HttpServletRequest request, ModelMap model) {
		return new ModelAndView("admin/brand/add.html", "brand", brand);
	}

	@RequestMapping(value = "/brand/addbrand", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("brand") Brand brand, ModelMap model) {
		brand.setName(brand.getName());
		brandService.insert(brand);
		model.addAttribute("brands", brandService.findAll());
		return new ModelAndView("admin/brand/index.html", "brand", brand);
	}

	@RequestMapping(value = "/brand/update", method = RequestMethod.GET)
	public ModelAndView update(HttpServletRequest request, ModelMap model) {
		model.addAttribute("Id", brandService.FindById(brand.getId()));
		request.setAttribute("updateBrand", brand);
		return new ModelAndView("admin/brand/update.html", "brand", brand);
	}
	
	@RequestMapping(value = "/brand/updateBrand", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("brand") Brand brand, ModelMap model) {
		brand.setId(brand.getId());
		brand.setName(brand.getName());
		brandService.update(brand);
		model.addAttribute("brands", brandService.findAll());
		return new ModelAndView("admin/brand/index.html", "brand", brand);
	}

}
