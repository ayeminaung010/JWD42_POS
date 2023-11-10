package com.ai.jwd42.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ai.jwd42.dto.Product;


public class ProductValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) { return
	Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1,"title", "required.title","title is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1,"description", "required.description","description is required.");

	} 
}
