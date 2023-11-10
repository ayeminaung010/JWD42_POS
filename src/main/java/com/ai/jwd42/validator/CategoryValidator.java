package com.ai.jwd42.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ai.jwd42.dto.Category;

public class CategoryValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) { return
	Category.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1,"name", "required.name","Category Name is required.");
	} 

}
