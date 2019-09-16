package io.codefountain.ftpserver.ftplet.core;

/**
 * A specific type of Ftp Reply that is sent out for 
 * commands which acs on a single file or directory
 * e.g. MKD, DELE, RMD, etc
 * 
 * @author musib
 *
 */
public interface FileActionFtpReply extends FtpReply{

	/**
	 * Returns the file or directory on which action has been
	 * taken
	 * @return the file or directory on which the action has
	 * taken, return <code>null</code> if file information is
	 * not available.
	 */
	public FtpFile getFile();
}
