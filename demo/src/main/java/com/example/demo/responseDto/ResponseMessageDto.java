package com.example.demo.responseDto;

public class ResponseMessageDto {

	private String message;

	public ResponseMessageDto() {
		super();
	}
	
	
	public ResponseMessageDto(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
