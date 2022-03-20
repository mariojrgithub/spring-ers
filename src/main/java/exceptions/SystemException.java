package exceptions;

public class SystemException extends Exception {

	@Override
	public String getMessage() {

		return "Application Failed. Please try again later!";
		
	}
	
	
}
