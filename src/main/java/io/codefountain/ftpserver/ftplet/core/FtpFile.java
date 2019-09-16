package io.codefountain.ftpserver.ftplet.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * This is the file abstraction used by the Ftp Server
 * 
 * @author musib
 *
 */
public interface FtpFile {

	/**
	 * Return the full path of the file from FileSystemView
	 * 
	 * @return
	 */
	String getAbsolutePath();
	
	/**
	 * Returns the file name 
	 * @return
	 */
	String getName();
	
	/**
	 * Is the {@link FtpFile} hidden
	 * @return
	 */
	boolean isHidden();
	
	/**
	 * Is the {@link FtpFile} readable?
	 * @return
	 */
	boolean isReadable();
	
	/**
	 * Is the {@link FtpFile} writable?
	 * @return
	 */
	boolean isWriteable();
	
	/**
	 * Is the {@link FtpFile} a directory?
	 * @return
	 */
	boolean isDirectory();
	
	/**
	 * Is the {@link FtpFile} a File?
	 * @return
	 */
	boolean isFile();
	
	/**
	 * Does the {@link FtpFile} exists?
	 * @return
	 */
	boolean doesExists();
	
	/**
	 * Has delete permission?
	 * @return
	 */
	boolean isRemovable();
	
	/**
	 * Returns the size of the file
	 * @return
	 */
	long getSize();
	
	/**
	 * Get the owner name
	 */
	String getOwnerName();
	
	/**
	 * Get the group name
	 * @return the group name this {@link FtpFile} belongs to
	 */
	String getGroupName();
	
	/**
	 * Get link count
	 * @return link count
	 */
	int getLinkCount();
	
	/**
	 * 
	 * Get the last modified time in UTC
	 * @return true if operation is successful
	 */
	long getLastModified();
	
	/**
	 * Set the last modification time stamp of the file
	 * @param time the value in milliseconds since epoch
	 * @return true if operation is successful
	 */
	boolean setLastModified(long time);
	
	/**
	 * Return the physical location of path of the file
	 * @return the physical location of path of the file
	 */
	Object getPhysicalFile();
	
	/**
	 * Create directory
	 * @return true if operation is successful
	 */
	boolean mkdir();
	
	/**
	 * Delete file
	 * @return true if operation is successful
	 */
	boolean delete();
	
	/**
	 * Move the file to destination location
	 * @param destination
	 * @return <code>true</code> if successfully moved, false otherwise 
	 */
	boolean move(FtpFile destination);
	
	/**
	 * List file objects. Returns <code>null</code> if {@link FtpFile} is not 
	 * a directory or does not exists. Files returned will be sorted alphabetically
	 * and the list will be immutable
	 * 
	 * @return The list of {@link FtpFile} files
	 */
	List<? extends FtpFile> listFiles();
	
	/**
	 * Create output stream for writing
	 * @param offset The number of bytes from where start writing. If the file
	 * is not random accessible, any value other than zero will 
	 * throw an exception
	 * @return An {@link OutputStream} to write the {@link FtpFile} file
	 * @throws IOException
	 */
	OutputStream createOutputStream(long offset) throws IOException;
	
	/**
	 * Create input stream for reading
	 * 
	 * @param offset The number of bytes from where start reading. If the file
	 * is not random accessible, any value other than zero will
	 * @return An {@link InputStream} to read the {@link FtpFile}
	 * @throws IOException
	 */
	InputStream creaInputStream(long offset) throws IOException;
}
