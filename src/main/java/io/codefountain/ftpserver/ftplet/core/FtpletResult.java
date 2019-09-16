package io.codefountain.ftpserver.ftplet.core;

/**
 * Encapsulates the return values of the ftplet results
 * 
 * DEFAULT < NO_FTPLET < SKIP < DISCONNECT
 * 
 * @author musib
 *
 */
public enum FtpletResult {

	/**
	 * Indicates that next ftplet method will be executed.
	 * If no more ftplet is available, server processed the
	 * request
	 */
	DEFAULT,
	
	/**
	 * Indicates that other ftplet methods will not be called but the 
	 * ftp server will continue processing the request.
	 */
	NO_FTPLET,
	
	/**
	 * Indicates FTP server will skip everything. No further processing
	 * ( by both ftplet and FTP server) will be done for this request
	 */
	SKIP,
	
	/**
	 * Indicates that server will skip and disconnect the client. No subsequent
	 * request from the same client will be served.
	 */
	DISCONNECT
}
