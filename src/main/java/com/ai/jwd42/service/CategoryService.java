package com.ai.jwd42.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.jwd42.dto.Category;
import com.ai.jwd42.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired 
	private CategoryRepo categoryRepo;
	
	public boolean addCategory(Category category) {
		boolean status = categoryRepo.addCategory(category);
		if (status) {
			return true;
		}
		return false;
	}
	
	public List<Category> findAll() {
		List<Category> categories = categoryRepo.findAll();
		return categories;
	}
}
