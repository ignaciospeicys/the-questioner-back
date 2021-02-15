package com.nicoynacho.questioner.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nicoynacho.questioner.dto.rest.AppError;
import com.nicoynacho.questioner.dto.rest.QuestionaireHttpInformation;
import com.nicoynacho.questioner.dto.rest.ServiceResponse;
import com.nicoynacho.questioner.service.IRestResponseService;

@Service
public class RestResponseServiceImpl implements IRestResponseService {

	@Override
	public ResponseEntity<ServiceResponse> buildResponse(QuestionaireHttpInformation httpInfo, Object body) {
		ServiceResponse response = new ServiceResponse();
		if (httpInfo.getIsError()) {
			AppError err = new AppError(httpInfo.getBusinessErrorCode(), httpInfo.getDetail());
			response.setError(err);
		}
		response.setData(body);
		return ResponseEntity.status(httpInfo.getCode()).body(response);
	}

}
