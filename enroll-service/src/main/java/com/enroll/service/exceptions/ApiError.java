package com.enroll.service.exceptions;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {
	private Date   timestamp;
	private String message;
	private String detail;
	private String status;
	public ApiError(Date timestamp, String message, String detail, String status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
		this.status = status;
	}

}
