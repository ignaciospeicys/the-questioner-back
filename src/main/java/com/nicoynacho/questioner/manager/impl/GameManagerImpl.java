package com.nicoynacho.questioner.manager.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicoynacho.questioner.dao.IGameDAO;
import com.nicoynacho.questioner.dto.GameAnswerDTO;
import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.entity.GameEntity;
import com.nicoynacho.questioner.exception.subtype.ElementNotFoundException;
import com.nicoynacho.questioner.manager.IGameManager;
import com.nicoynacho.questioner.service.IEntityMapper;
import com.nicoynacho.questioner.util.QuestionerAnswerMatcher;

@Service
public class GameManagerImpl implements IGameManager {
	
	@Autowired
	private IGameDAO gameDAO;
	
	@Autowired
	private IEntityMapper mapper;

	@Override
	public Long create(GameDTO input) {
		GameEntity game = mapper.convert(input);
		gameDAO.save(game);
		return game.getId();
	}
	
	@Override
	public GameDTO find(Long gameId) throws ElementNotFoundException {
		GameEntity game = get(gameId);
		return mapper.convert(game);
	}
	
	@Override
	public GameAnswerDTO checkAnswer(Long gameId, GameDTO inputGame) throws ElementNotFoundException {
		String inputAnswer = inputGame.getGameAnswer();
		GameEntity game = get(gameId);
		String originalAnswer = game.getQuestionAnswer();
		boolean match = QuestionerAnswerMatcher.doAnswersMatch(originalAnswer, inputAnswer);
		return new GameAnswerDTO(match, game.getQuestionAnswer());
	}
	
	private GameEntity get(Long id) throws ElementNotFoundException {
		Optional<GameEntity> game = gameDAO.findById(id);
		if (!game.isPresent())
			throw new ElementNotFoundException("The requested game does not exist");
		return game.get();
	}

}
