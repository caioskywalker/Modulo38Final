package br.com.cfarias.exceptions;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7800330769188623719L;

	public DAOException(String msg, Exception ex) {
		super (msg,ex);
	}
	
}
