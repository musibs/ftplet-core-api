package io.codefountain.ftpserver.ftplet.core;

import java.io.IOException;
import java.util.Objects;

/**
 * Defines operations that all ftplets must implement.
 * 
 * An ftplet is a small Java program that runs in the FTP server. Ftplets
 * receive and responds to the requests from FTP clients.
 * 
 * This interface defines the methods to initialize a ftplet, to service
 * requests and remove a ftplet from the server. These are known as life cycle
 * methods and are invoked in below sequence:
 * 
 * <ol>
 * <li>ftplet is constructed</li>
 * <li>ftplet is initialized with init() call</li>
 * <li>All callback methods are invoked</li>
 * <li>ftplet is taken out of service and destroy() call is invoked</li>
 * <li>ftplet is garbage collected</li>
 * </ol>
 * 
 * All callback methods return FtpletEnum. In case an ftplet returns <code>null</code>,
 * FtpletEnum.DEFAULT will be assumed. If any ftplet callback method ends up with an
 * exception, particular connection will be disconnected.
 * 
 * @author musib
 *
 */
public interface Ftplet {

	/**
	 * Called by the ftplet container to indicate that a ftplet is being put into
	 * service. This method is invoked by the container only once after instantiating 
	 * the ftplet. This method must be completed successfully before the ftplet can 
	 * service requests.
	 * 
	 * @param ftpletContext the current ftpcontext
	 * @throws FtpException
	 */
	default void init(FtpletContext ftpletContext) throws FtpException{}
	
	/**
	 * Called by the ftplet container to indicate to a ftplet that it is taken out from 
	 * the service. This method is only invoked once all threads exit the ftplet service
	 * method. After the ftplet conainer invokes this method no more callback methods will
	 * be executed. This method will not be invoked if ftplet initialization fails 
	 * 
	 */
	default void destroy() {}
	
	/**
	 * Action to be performed by the server on connection
	 * 
	 * @return Desired action to be performed by the server on connection
	 * @throws FtpException
	 * @throws IOException
	 */
	default FtpletResult onConnect() throws FtpException, IOException {
		return null;
	}
	
	/**
	 * Action to be performed by the server after disconnection from the client
	 * 
	 * @return Desired action to be performed by the server on connection
	 * @throws FtpException
	 * @throws IOException
	 */
	default FtpletResult onDisConnect() throws FtpException, IOException {
		return null;
	}
	
	/**
	 * Called by the ftplet container before a fltpet is executed.The implementation should
	 * return based on the desired action to be taken by the server:
	 * 
	 * <ul>
	 * 	<li>{@code FtpletResult#DEFAULT} The server continues as normal</li>
	 * <li>{@code FtpletResult#NO_FTPLET} Server does not call any more ftplet
	 * but continues execution of the command as usual</li>
	 * <li>{@code FtpletResult#SKIP} Server skips the execution of the command. Note
	 * that ftplet must reply to the client to prevent client deadlock</li>
	 * <li>{@code FtpletResult#DISCONNECT} The server immediately disconnect the client</li>
	 * <li>Ftplet throws an exception. same as of @{code {@link FtpletResult#DISCONNECT}}</li>
	 * </ul>
	 * @param ftpSession current ftpsession
	 * @param ftpRequest current ftprequest
	 * @return {@link FtpletResult} desired action to be performed by the server
	 * @throws FtpException
	 * @throws IOException
	 */
	default FtpletResult beforeCommand(FtpSession ftpSession, FtpRequest ftpRequest) throws FtpException, IOException{
		Objects.requireNonNull(ftpSession, "session can not be null");
		Objects.requireNonNull(ftpRequest, "ftp request can not be null");
		Objects.requireNonNull(ftpRequest.getCommand(), "ftp request command can not be null");
		
		String command = ftpRequest.getCommand().toUpperCase();
		Commands commandEnum = Commands.valueOf(command);
		switch(commandEnum) {
			case DELE: return onDeleteStart(ftpSession, ftpRequest);
			case STOR: return onUploadStart(ftpSession, ftpRequest);
			case RETR: return onUploadStart(ftpSession, ftpRequest);
			case RMD: return onRmdirStart(ftpSession, ftpRequest);
			case MKD: return onMkdirStart(ftpSession, ftpRequest);
			case APPE: return onAppendStart(ftpSession, ftpRequest);
			case STOU: return onUploadUniqueStart(ftpSession, ftpRequest);
			case RNTO: return onRenameStart(ftpSession, ftpRequest);
			case SITE: return onSiteStart(ftpSession, ftpRequest);
			default:return null;
		}
	}
	
	default FtpletResult onSiteStart(FtpSession ftpSession, FtpRequest ftpRequest) {return null;} 

	default FtpletResult onRenameStart(FtpSession ftpSession, FtpRequest ftpRequest) {return null;}

	default FtpletResult onUploadUniqueStart(FtpSession ftpSession, FtpRequest ftpRequest) {return null;}

	default FtpletResult onMkdirStart(FtpSession ftpSession, FtpRequest ftpRequest) {return null;}

	default FtpletResult onAppendStart(FtpSession ftpSession, FtpRequest ftpRequest) {return null;}

	default FtpletResult onRmdirStart(FtpSession ftpSession, FtpRequest ftpRequest) {return null;}

	default FtpletResult onUploadStart(FtpSession ftpSession, FtpRequest ftpRequest) {return null;}

	default FtpletResult onDeleteStart(FtpSession ftpSession, FtpRequest ftpRequest) {return null;}

	/**
	 * Called by the ftplet container after a fltpet is executed.The implementation should
	 * return based on the desired action to be taken by the server:
	 * 
	 * <ul>
	 * 	<li>{@code FtpletResult#DEFAULT} The server continues as normal</li>
	 * <li>{@code FtpletResult#NO_FTPLET} Server does not call any more ftplet
	 * but continues execution of the command as usual</li>
	 * <li>{@code FtpletResult#SKIP} Server skips the execution of the command. Note
	 * that ftplet must reply to the client to prevent client deadlock</li>
	 * <li>{@code FtpletResult#DISCONNECT} The server immediately disconnect the client</li>
	 * <li>Ftplet throws an exception. same as of @{code {@link FtpletResult#DISCONNECT}}</li>
	 * </ul>
	 * @param ftpSession current ftpsession
	 * @param ftpRequest current ftprequest
	 * @return {@link FtpletResult} desired action to be performed by the server
	 * @throws FtpException
	 * @throws IOException
	 */
	FtpletResult afterCommand(FtpSession ftpSession, FtpRequest ftpRequest, FtpReply ftpReply) throws FtpException, IOException;
	
	/**
	 * Client connect notification method
	 * 
	 * @param ftpSession, current ftp session
	 * @return {@link FtpletResult} desired action to be performed by the server
	 * @throws FtpException
	 * @throws IOException
	 */
	FtpletResult onConnect(FtpSession ftpSession) throws FtpException, IOException;
	
	/**
	 * Client disconnect notification method. This is the last callback method
	 * @param ftpSession current ftp session
	 * @return {@link FtpletResult} desired action to be performed by the server
	 * @throws FtpException
	 * @throws IOException
	 */
	FtpletResult onDisconnect(FtpSession ftpSession) throws FtpException, IOException;
	
	
	
}
