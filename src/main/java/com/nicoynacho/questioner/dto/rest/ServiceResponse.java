package com.nicoynacho.questioner.dto.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceResponse {
	
	@JsonProperty("service_operation")
	private String operation;
	
	@JsonProperty("data")
	private Object data;
	
	@JsonProperty("error")
	private AppError error;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public AppError getError() {
		return error;
	}

	public void setError(AppError error) {
		this.error = error;
	}
}
