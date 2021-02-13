package com.nicoynacho.questioner.dto.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceResponse {
	
	@JsonProperty("service_operation")
	private String operation;
	
	@JsonProperty("data")
	private Object data;
	
	@JsonProperty("error")
	private AppError error;
	
	
}
