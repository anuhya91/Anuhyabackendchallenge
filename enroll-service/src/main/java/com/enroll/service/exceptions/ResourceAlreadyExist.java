package com.enroll.service.exceptions;

public class ResourceAlreadyExist extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public ResourceAlreadyExist(String message) {
		this.message = message;

	}

	public String getMsg() {
		return message;
	}

}
