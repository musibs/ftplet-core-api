package io.codefountain.ftpserver.ftplet.core;

/**
 * Type safe enum to describe data types
 * 
 * @author musib
 *
 */
public enum DataType {

	/**
	 * Binary data type
	 */
	BINARY,

	/**
	 * ASCII data type
	 */
	ASCII;

	/**
	 * Parse the {@link Character} argument from the TYPE command into type safe
	 * data type
	 * 
	 * @param ch
	 * @return The appropriate data type
	 * @throws IllegalArgumentException if data type is unknown
	 */
	public static DataType parse(char ch) {
		switch (ch) {
		case 'A':
		case 'a':
			return ASCII;
		case 'I':
		case 'i':
			return BINARY;
		default:
			throw new IllegalArgumentException("Unknow data type: " + ch);
		}
	}
}
