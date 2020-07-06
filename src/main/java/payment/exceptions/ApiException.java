package payment.exceptions;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice // if any exception will come to any controller then it'll come to here.
public class ApiException {

	@ExceptionHandler(value=DatabaseException.class)// whenever any DatabaseException will reach to controller then that will get redirect to here.
	public ResponseEntity<Object> handleDatabaseException(DatabaseException ex) {
		
		return new ResponseEntity<Object>(ex, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=TokenExpiryException.class)// when ever any TokenExpiryException will reach to controller then that will get redirect to here.
	public ResponseEntity<Object> handleTokenExpiryException(TokenExpiryException ex) {
		
		return new ResponseEntity<Object>(ex, HttpStatus.REQUEST_TIMEOUT);
	}
	
}
