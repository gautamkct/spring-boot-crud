package com.test.crud.dto;

import java.util.Date;

public class ErrorDto {

	private String message;
	private String details;
	private Date timestamp;

	public ErrorDto(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

}
