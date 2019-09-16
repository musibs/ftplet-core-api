package io.codefountain.ftpserver.ftplet.core;

/**
 * A Connection factory to obtain {@link DataConnection}
 * 
 * @author musib
 *
 */
public interface DataConnectionFactory {

	/**
	 * Opens an active {@link DataConnection}
	 * 
	 * @return {@link DataConnection}, The open data connection
	 * @throws Exception
	 */
	DataConnection openConnection() throws Exception;
	
	/**
	 * Indicates whether this {@link DataConnection} runs securely
	 * i.e. runs over a SSL/TLS connection
	 * @return
	 */
	boolean isSecure();
	
	/**
	 * Closes an active data connection. This method silently
	 * ignores tha call if there are no active data connection
	 * available
	 */
	void closeDataConnection();
}
