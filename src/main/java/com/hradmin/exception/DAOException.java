package com.hradmin.exception;

public class DAOException extends ValdelHrAdminException {

	/**
	 * if topic for user are not found 
	 */
	private static final long serialVersionUID = 1L;
	
	public DAOException(String message)
	{
		super(message);
	}

//	public DAOException(String error,String message)
//	{
//		super(error,message);
//	}
	
}
