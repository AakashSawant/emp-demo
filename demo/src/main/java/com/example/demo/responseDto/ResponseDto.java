package com.example.demo.responseDto;

public class ResponseDto {

	private Boolean isSuccess;
	private Boolean isFailed;
	private Object response;

	public ResponseDto() {
		super();
	}

	public ResponseDto(Boolean isSuccess, Boolean isFailed, Object response) {
		super();
		this.isSuccess = isSuccess;
		this.isFailed = isFailed;
		this.response = response;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Boolean getIsFailed() {
		return isFailed;
	}

	public void setIsFailed(Boolean isFailed) {
		this.isFailed = isFailed;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
