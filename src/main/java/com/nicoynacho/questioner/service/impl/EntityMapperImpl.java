package com.nicoynacho.questioner.service.impl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.dto.QuestionDTO;
import com.nicoynacho.questioner.entity.GameEntity;
import com.nicoynacho.questioner.entity.QuestionEntity;
import com.nicoynacho.questioner.enums.GameCategoryEnum;
import com.nicoynacho.questioner.service.IEntityMapper;

@Service
public class EntityMapperImpl implements IEntityMapper {

	@Override
	public GameEntity convert(GameDTO input) {
		GameEntity game = new GameEntity();
		game.setGameName(input.getGameName());
		game.setMaxAttempts(input.getMaxAttempts());
		game.setQuestionAnswer(input.getGameAnswer());
		game.setQuestionDetail(input.getGameQuestion());
		game.setCategory(GameCategoryEnum.findByName(input.getGameCategory()));
		return game;
	}

	@Override
	public GameDTO convert(GameEntity entity) {
		GameDTO game = new GameDTO();
		game.setGameName(entity.getGameName());
		game.setGameCategory(entity.getCategory().name());
		game.setMaxAttempts(entity.getMaxAttempts());
		game.setGameQuestion(entity.getQuestionDetail());
		game.setQuestions(entity.getQuestionsReceived().stream().map(this::convert).collect(Collectors.toList()));
		return game;
	}
	
	@Override
	public QuestionDTO convert(QuestionEntity entity) {
		QuestionDTO question = new QuestionDTO();
		question.setAnswer(entity.getDetail());
		question.setUsername(entity.getUsername());
		question.setGameId(entity.getGameId());
		return question;
	}

}
