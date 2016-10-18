/* Commented out because of errors

package com.unisyd_elec5619.springmvc.exceptionshandler;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

//  NEEDS TO IMPLEMENT SOME CONSTRAINTSVALIDATOR INTERFACE WHICH IS USED FOR THIS TO VALIDATE STRINGS VIA @VALIDEMAIL ANNOTATION
public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {

	private int min;

	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		min = constraintAnnotation.min();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if (email.length() < min) {
			return false;
		} else if (!EmailValidator.getInstance(false).isValid(email)) {
			return false;
		}

		return true;

	}

}

*/