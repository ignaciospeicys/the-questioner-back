package com.nicoynacho.questioner.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.dto.rest.QuestionaireHttpInformation.QuestionaireInfoBuilder;
import com.nicoynacho.questioner.dto.rest.ServiceResponse;
import com.nicoynacho.questioner.manager.IGameManager;
import com.nicoynacho.questioner.service.IRestResponseService;

@RestController
@RequestMapping(name = "v1/game")
public class GameController {
	
	@Autowired
	private IGameManager manager;
	
	@Autowired
	private IRestResponseService responseService;
	
	@PostMapping
	public ResponseEntity<ServiceResponse> doCreate(@RequestBody GameDTO game, HttpServletRequest req) {
		manager.create(game);
		return responseService.buildResponse(
				new QuestionaireInfoBuilder()
					.setCode(200)
					.setHttpMethod(HttpMethod.POST)
					.setOperation(req.getRequestURI())
				.build());
	}

}