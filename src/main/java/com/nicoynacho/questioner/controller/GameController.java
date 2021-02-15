package com.nicoynacho.questioner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.dto.rest.QuestionaireHttpInformation.QuestionaireInfoBuilder;
import com.nicoynacho.questioner.dto.rest.ServiceResponse;
import com.nicoynacho.questioner.exception.subtype.ElementNotFoundException;
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
		Long resourceId = manager.create(game);
		return responseService.buildResponse(
				new QuestionaireInfoBuilder()
					.setCode(200)
					.setHttpMethod(HttpMethod.POST)
					.setOperation(req.getRequestURI())
				.build(), resourceId);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ServiceResponse> doFetch(@RequestParam Long id, HttpServletRequest req) throws ElementNotFoundException {
		GameDTO response = manager.findAndConvert(id);
		return responseService.buildResponse(
				new QuestionaireInfoBuilder()
					.setCode(200)
					.setHttpMethod(HttpMethod.GET)
					.setOperation(req.getRequestURI())
				.build(), response);
	}
	
	@GetMapping
	public ResponseEntity<ServiceResponse> doFetchAll(HttpServletRequest req) throws ElementNotFoundException {
		List<GameDTO> response = manager.findAll();
		return responseService.buildResponse(
				new QuestionaireInfoBuilder()
					.setCode(200)
					.setHttpMethod(HttpMethod.GET)
					.setOperation(req.getRequestURI())
				.build(), response);
	}

}
