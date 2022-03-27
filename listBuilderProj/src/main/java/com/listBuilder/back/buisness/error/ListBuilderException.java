package com.listBuilder.back.buisness.error;

import com.listBuilder.back.buisness.error.ListBuilderEventCode;

public class ListBuilderException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5380984358002252256L;
	
	private ListBuilderEventCode eventCode;
	
	public ListBuilderException(ListBuilderEventCode eventCode) {
		this.eventCode = eventCode;
	}
	
	public ListBuilderException(ListBuilderEventCode eventCode, String message) {
		super(message);
		this.eventCode = eventCode;
	}
	
	public ListBuilderException(ListBuilderEventCode eventCode, String message, Throwable cause) {
		super(message, cause);
		this.eventCode = eventCode;
	}
}