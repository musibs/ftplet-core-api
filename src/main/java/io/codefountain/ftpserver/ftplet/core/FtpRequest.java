package io.codefountain.ftpserver.ftplet.core;

/**
 * One FTP request made by the client
 * @author musib
 *
 */
public interface FtpRequest {

	/**
	 * Get the client request string
	 * 
	 * @return full request line e.g. "MKDIR newDir"
	 */
	String getRequestLine();
	
	/**
	 * Returns the FTP request command
	 * 
	 * @return The command part of the request line e.g. "MKDIR"
	 */
	String getCommand();
	
	/**
	 * Check if request has an argument
	 * @return true if request has an argument
	 */
	boolean hasArgument();
	
	/**
	 * Return the argument from the FTP request
	 * @return argument from the FTP request
	 */
	String getArgument();
	
	/**
	 * Returns the time (millisecond since the epoch time) when this request 
	 * was received
	 * @return the time (millisecond since the epoch time) when this request 
	 * was received
	 */
	long getReceivedTime();
}
