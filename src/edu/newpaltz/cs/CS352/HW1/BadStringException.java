package edu.newpaltz.cs.CS352.HW1;

public class BadStringException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BadStringException() {
		super();		
	}
	public BadStringException(String message) {
		super(message);		
	}
}
