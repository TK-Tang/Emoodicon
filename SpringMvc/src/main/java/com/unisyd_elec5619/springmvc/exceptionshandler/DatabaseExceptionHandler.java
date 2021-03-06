package com.unisyd_elec5619.springmvc.exceptionshandler;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Controller advice part of AOP
// Method advising another method (???)

@ControllerAdvice
public class DatabaseExceptionHandler {
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex){	
		System.out.println(ex);
		return "error";
	}

}

