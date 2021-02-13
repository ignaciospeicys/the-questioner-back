package com.nicoynacho.questioner.dto.rest;

import org.springframework.http.HttpMethod;

import com.nicoynacho.questioner.exception.QuestionerPapaException;

public class QuestionaireHttpInformation {
	
	private Integer code;
	
	private String businessErrorCode;
	
	private String operation;
	
	private String detail;
	
	private String clazz;
	
	private HttpMethod httpMethod;
	
	private QuestionaireHttpInformation() {
	}
	
	public static class QuestionaireInfoBuilder {
		
		protected QuestionaireHttpInformation questionaireHttpInformation;
		
		public QuestionaireInfoBuilder() {
			questionaireHttpInformation = new QuestionaireHttpInformation();
		}
		
		public QuestionaireInfoBuilder setCode(Integer code) {
			questionaireHttpInformation.code = code;
			return this;
		}
		
		public QuestionaireInfoBuilder setOperation(String operation) {
			questionaireHttpInformation.operation = operation;
			return this;
		}
		
		public QuestionaireInfoBuilder setHttpMethod(HttpMethod httpMethod) {
			questionaireHttpInformation.httpMethod = httpMethod;
			return this;
		}
		
		public QuestionaireHttpInformation build() {
			return questionaireHttpInformation;
		}
		
		public QuestionaireErrorBuilder enableErrorMode() {
			return new QuestionaireErrorBuilder();
		}
	}
	
	public static class QuestionaireErrorBuilder extends QuestionaireInfoBuilder {

		public QuestionaireErrorBuilder setException(Exception e) {
			questionaireHttpInformation.code = e instanceof QuestionerPapaException ? ((QuestionerPapaException)e).getCode() : Integer.valueOf(500);
			questionaireHttpInformation.businessErrorCode = e instanceof QuestionerPapaException ? ((QuestionerPapaException)e).getBusinessErrorCode() : questionaireHttpInformation.code.toString();
			questionaireHttpInformation.detail = e.getMessage();
			questionaireHttpInformation.clazz = e.getClass().getSimpleName();
			return this;
		}
		
		public QuestionaireErrorBuilder setDetail(String detail) {
			questionaireHttpInformation.detail = detail;
			return this;
		}
		
		public QuestionaireErrorBuilder setBusinessErrorCode(String code) {
			questionaireHttpInformation.businessErrorCode = code;
			return this;
		}
		
		public QuestionaireErrorBuilder setClazz(String clazz) {
			questionaireHttpInformation.clazz = clazz;
			return this;
		} 
	}

	public Integer getCode() {
		return code;
	}

	public String getBusinessErrorCode() {
		return businessErrorCode;
	}

	public String getOperation() {
		return operation;
	}

	public String getDetail() {
		return detail;
	}

	public String getClazz() {
		return clazz;
	}

	public HttpMethod getHttpMethod() {
		return httpMethod;
	}

}
