package com.nicoynacho.questioner.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nicoynacho.questioner.dto.rest.QuestionaireHttpInformation.QuestionaireInfoBuilder;
import com.nicoynacho.questioner.dto.rest.ServiceResponse;
import com.nicoynacho.questioner.service.IRestResponseService;

public abstract class AbstractController {
	
	@Autowired
	protected IRestResponseService responseService;

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ServiceResponse> onException(HttpServletRequest request, Exception e) {
		
		return responseService.buildResponse(
				new QuestionaireInfoBuilder()
					.enableErrorMode()
					.setException(e)
					.setHttpMethod(HttpMethod.resolve(request.getMethod()))
					.setOperation(request.getRequestURI())
					.build(), null);
		
	}
}