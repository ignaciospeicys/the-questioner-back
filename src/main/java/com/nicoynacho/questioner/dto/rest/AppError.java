package com.nicoynacho.questioner.dto.rest;

public class AppError {
	
	private String code;
	
	private String detail;
	
	public AppError(String code, String detail) {
		this.code = "APP_ERR_".concat(code);
		this.detail = detail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
