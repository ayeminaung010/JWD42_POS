package com.ai.jwd42.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.jwd42.dto.Product;
import com.ai.jwd42.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired 
	private ProductRepo productRepo;
	
	public boolean addProduct(Product product) {
		boolean status = productRepo.addProduct(product);
		if (status) {
			return true;
		}
		return false;
	}
	
	public List<Product> findAll() {
		List<Product> products = productRepo.findAll();
		return products;
	}
}
