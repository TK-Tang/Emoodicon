package Controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Controller advice part of AOP
// Method advising another method (???)

@ControllerAdvice
public class DatabaseExceptionHandler {
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex){	
		ex.printStackTrace();
		return "Error";
	}
}
