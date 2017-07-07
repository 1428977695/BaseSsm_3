package com.hbst.basessm_1.util.exception;


 
public class BaseIOException extends BaseRunTimeException {
    /**
	 *serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    public BaseIOException() {
        super();
    }
 
    public BaseIOException(String message) {
        super(message);
    }
 
    public BaseIOException(Throwable cause) {
        super(cause);
    }

    public BaseIOException(String message, Throwable cause) {
        super(message, cause);
    }
}
