package io.codefountain.ftpserver.ftplet.core;

/**
 * A more specific type of {@link FtpReply} that is sent by the commands
 * that transfer data over {@link DataConnection}. These commands includes
 * LIST, RETR, STOR, STOU etc
 * 
 * @author musib
 *
 */
public interface DataTransferFtpReply extends FileActionFtpReply{

	/**
	 * Returns the number of bytes transferred
	 * 
	 * @return number of bytes transferred
	 */
	long getBytesTransferred();
}
