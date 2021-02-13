package com.nicoynacho.questioner.exception;

public class QuestionerPapaException extends Exception {
	
	private static final long serialVersionUID = -1L;
	
	protected Integer code;
	
	protected String businessErrorCode;
	
	protected String message;

	public QuestionerPapaException(Integer code, String message) {
		super(message);
		this.code = code;
		this.businessErrorCode = String.valueOf(code);
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getBusinessErrorCode() {
		return businessErrorCode;
	}

	public void setBusinessErrorCode(String businessErrorCode) {
		this.businessErrorCode = businessErrorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
