package com.nicoynacho.questioner.service;

import org.springframework.http.ResponseEntity;

import com.nicoynacho.questioner.dto.rest.QuestionaireHttpInformation;
import com.nicoynacho.questioner.dto.rest.ServiceResponse;

public interface IRestResponseService {
	
	ResponseEntity<ServiceResponse> buildResponse(QuestionaireHttpInformation httpInfo, Object body);

}
