package io.codefountain.ftpserver.ftplet.core;

/**
 * Exception thrown when an authentication fails
 * 
 * @author musib
 *
 */
public class AuthenticationFailedException extends FtpException{

	private static final long serialVersionUID = -4364241210328592934L;

	/**
	 * Default constructor
	 */
	public AuthenticationFailedException() {
		super();
	}
	
	/**
	 * Constructs an {@link AuthenticationFailedException} with a custom 
	 * error message
	 * @param message
	 */
	public AuthenticationFailedException(String message) {
		super(message);
	}
	
	/**
	 * Constructs an {@link AuthenticationFailedException} with a {@link Throwable}
	 * cause
	 * 
	 * @param cause
	 */
	public AuthenticationFailedException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructs an {@link AuthenticationFailedException} with a custom error message
	 * and a {@link Throwable} cause
	 * 
	 * @param message
	 * @param cause
	 */
	public AuthenticationFailedException(String message, Throwable cause) {
		super(message, cause);
	}
}
