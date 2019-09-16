package io.codefountain.ftpserver.ftplet.core;

/**
 * Authority granted to the user. For example, write access or
 * number of concurrent logins
 * 
 * @author musib
 *
 */
public interface Authority {

	/**
	 * Decides whether {@link AuthorizationRequest} can be authorized.
	 * 
	 * @param authorizationRequest, The request that needs to be authorized
	 * @return True, if the request can be authorized by this Authority
	 */
	boolean canAuthorize(AuthorizationRequest authorizationRequest);
	
	/**
	 * Authorizes an {@link AuthorizationRequest}
	 * 
	 * @param authorizationRequest, The request that needs to be authorized
	 * @return A populated {@link AuthorizationRequest} as long as {@link #canAuthorize(AuthorizationRequest)}
	 * returns true. Otherwise returns null.
	 * {@link #canAuthorize(AuthorizationRequest)} is always checked before invoking this method.
	 */
	AuthorizationRequest authorize(AuthorizationRequest authorizationRequest);
}
