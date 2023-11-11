package com.ai.jwd42.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.jwd42.dto.Brand;
import com.ai.jwd42.repo.BrandRepo;

@Service
public class BrandService {
	@Autowired
	private BrandRepo brandRepo;

//	public boolean addBrand(Brand brand) {
//		boolean status = brandRepo.addBrand(brand);
//		if (status) {
//			return true;
//		}
//		return false;
//	}
//	
	public List<Brand> findAll() {
		List<Brand> brand = brandRepo.findAll();
		return brand;
	}

	public int insert(Brand brand) {
		BrandRepo brandRepo = new BrandRepo();
		return brandRepo.insert(brand);
	}

	public void update(Brand brand) {
		BrandRepo brandRepo = new BrandRepo();
		brandRepo.update(brand);
	}

	public Brand FindById(int Id) {
		BrandRepo brandRepo = new BrandRepo();
		return brandRepo.FindById(Id);
	}

}
