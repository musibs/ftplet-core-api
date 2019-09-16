package io.codefountain.ftpserver.ftplet.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Represents the data connection between FTPServer and FTPCliet
 * 
 * @author musib
 *
 */
public interface DataConnection {

	/**
	 * Transfer data from a Client (STOR)
	 * 
	 * @param ftpSession, current {@link FtpSession}
	 * @param out, {@link OutputStream} containing the destination of data 
	 * from the client
	 * @return The length of transferred data
	 * @throws IOException
	 */
	long transferFromClient(FtpSession ftpSession, OutputStream out) throws IOException;
	
	/**
	 * Transfer data to a client (RETR)
	 * 
	 * @param ftpSession, current {@link FtpSession}
	 * @param in, Data to be transferred to the client
	 * @return The length of the transferred data
	 * @throws IOException
	 */
	long transferToClient(FtpSession ftpSession, InputStream in) throws IOException;
	
	/**
	 * Transfer a String to the client. e.g. During LIST
	 * 
	 * @param ftpSession, current {@link FtpSession}
	 * @param message, the {@link String} to be transferred to the client
	 * @return
	 * @throws IOException
	 */
	long transferToClinet(FtpSession ftpSession, String message) throws IOException;
}
