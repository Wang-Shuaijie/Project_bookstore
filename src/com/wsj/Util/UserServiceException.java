package com.wsj.Util;

public class UserServiceException extends Exception{
	private static final long serialVersionUID = 1L;
	public UserServiceException(String msg) {
		super(msg);
	}
	public UserServiceException(String msg,Exception e) {
		super(msg, e);
	}
	public UserServiceException() {
		super();
	}
	

}
