package com.ai.jwd42.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.jwd42.dto.SubCategory;
import com.ai.jwd42.repo.SubCategoryRepo;

@Service
public class SubCategoryService {
	@Autowired 
	private SubCategoryRepo subcategoryRepo;
	
	public boolean addsubCategory(SubCategory subcategory) {
		boolean status = subcategoryRepo.addsubCategory(subcategory);
		if (status) {
			return true;
		}
		return false;
	}
	
	public List<SubCategory> findAll() {
		List<SubCategory> subcategories = subcategoryRepo.findAll();
		return subcategories;
	}
}
