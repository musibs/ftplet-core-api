package io.codefountain.ftpserver.ftplet.core;

import java.util.Objects;

/**
 * Default Ftp reply Object
 * 
 * @author musib
 *
 */
public class DefaultFtpReply implements FtpReply {

	private int code;
	private String message;
	private long sentTime;

	private static final int REPLY_CODE_THRESHOLD = 400;
	private static final String CRLF = "\r\n";

	public DefaultFtpReply(final int code, final String message) {
		this.code = code;
		this.message = message;
		this.sentTime = System.currentTimeMillis();
	}

	public DefaultFtpReply(final int code, final String[] messages) {

		Objects.requireNonNull(messages, "Messages can not be null");
		this.code = code;
		StringBuilder builder = new StringBuilder();
		for (String msg : messages) {
			builder.append(msg).append("\n");
		}
		this.message = builder.toString();
		this.sentTime = System.currentTimeMillis();

	}

	public int returnCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public long getSentTime() {
		return sentTime;
	}

	public boolean isPostive() {
		return code < REPLY_CODE_THRESHOLD;
	}

	private boolean isDigit(char c) {
		return c >= 48 && c <= 57;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		int code = returnCode();
		String message = getMessage();
		
		if(Objects.isNull(message)) {
			message = "";
		}
		
		message = message.replace("\r", "");
		
		String[] lines = message.split("\n");
		
		if(lines.length == 1) {
			builder.append(code).append(" ").append(message).append(CRLF);
		}
		else {
			String line = null;
			builder.append(code).append("-");
			for(int i=0; i< lines.length; i++) {
				line = lines[i];
				
				if((i+1) == lines.length) {
					builder.append(code).append(" ");
				}
				
				if(i > 0 
						&& i+1 < lines.length 
						&& line.length() == 2 
						&& isDigit(line.charAt(0))
						&& isDigit(line.charAt(1))
						&& isDigit(line.charAt(2))){
					builder.append(" ");
				}
				builder.append(" ").append(CRLF);
			}
		}
		return builder.toString();
	}

}
