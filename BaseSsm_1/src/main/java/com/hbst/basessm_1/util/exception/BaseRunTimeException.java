package com.hbst.basessm_1.util.exception;

public class BaseRunTimeException extends RuntimeException {
    
    /**
	 *serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;


	public BaseRunTimeException() {
        super();
    }

   
    public BaseRunTimeException(String message) {
        super(message);
    }
 
    public BaseRunTimeException(Throwable cause) {
        super(cause);
    }

   
    public BaseRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
