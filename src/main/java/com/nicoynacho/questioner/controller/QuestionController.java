package com.nicoynacho.questioner.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicoynacho.questioner.dto.GameAnswerDTO;
import com.nicoynacho.questioner.dto.QuestionDTO;
import com.nicoynacho.questioner.dto.rest.QuestionaireHttpInformation.QuestionaireInfoBuilder;
import com.nicoynacho.questioner.dto.rest.ServiceResponse;
import com.nicoynacho.questioner.exception.subtype.ElementNotFoundException;
import com.nicoynacho.questioner.manager.IQuestionManager;
import com.nicoynacho.questioner.service.IRestResponseService;

@RestController
@RequestMapping("v1/question")
public class QuestionController {
	
	@Autowired
	private IQuestionManager manager;
	
	@Autowired
	private IRestResponseService responseService;

	@PostMapping
	public ResponseEntity<ServiceResponse> postAnswer(@RequestBody QuestionDTO question, HttpServletRequest req) throws ElementNotFoundException {
		GameAnswerDTO response = manager.submitAnswer(question);
		return responseService.buildResponse(
				new QuestionaireInfoBuilder()
					.setCode(200)
					.setHttpMethod(HttpMethod.POST)
					.setOperation(req.getRequestURI())
				.build(), response);
	}
}
