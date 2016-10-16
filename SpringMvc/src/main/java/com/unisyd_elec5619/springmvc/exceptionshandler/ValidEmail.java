
/* Commented out because of errors

package com.unisyd_elec5619.springmvc.exceptionshandler;


import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = { Validations.ValidEmailImpl.class })
public @interface ValidEmail {

	String message() default "Invalid Email.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


	 // @return size the element must be higher or equal to

	int min() default 5;

	
	int max() default Integer.MAX_VALUE;
}

*/