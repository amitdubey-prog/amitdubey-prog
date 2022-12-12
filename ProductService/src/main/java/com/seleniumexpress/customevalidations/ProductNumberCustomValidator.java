package com.seleniumexpress.customevalidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductNumberCustomValidator implements ConstraintValidator<ProductNumberValidator, String>  {

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean flag = false;
		if(value != null) {
			value = value.toLowerCase();
			if(value.length()==8 && value.startsWith("sel")) {
				flag = true;
			}
		}
		return flag;
	}
	
	



}
