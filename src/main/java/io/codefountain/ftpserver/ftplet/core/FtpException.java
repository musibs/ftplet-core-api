package io.codefountain.ftpserver.ftplet.core;

/**
 * FTP Exception class
 * 
 * @author musib
 *
 */
public class FtpException extends Exception {

	private static final long serialVersionUID = 2627946858964005949L;
	
	/**
	 * Default constructor
	 */
	public FtpException() {
		super();
	}
	
	/**
	 * FTP Exception with a specific message
	 * 
	 * @param message
	 */
	public FtpException(String message) {
		super(message);
	}
	
	/**
	 * FTP Exception with {@link Throwable}
	 * @param cause
	 */
	public FtpException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * FTP Exception with a custom message and throwable cause
	 * @param message
	 * @param cause
	 */
	public FtpException(String message, Throwable cause) {
		super(message, cause);
	}

}
