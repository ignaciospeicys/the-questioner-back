package com.nicoynacho.questioner.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicoynacho.questioner.dao.IGameDAO;
import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.entity.GameEntity;
import com.nicoynacho.questioner.manager.IGameManager;

@Service
public class GameManagerImpl implements IGameManager {
	
	@Autowired
	private IGameDAO gameDAO;

	@Override
	public Long create(GameDTO input) {
		GameEntity game = convert(input);
		gameDAO.save(game);
		return game.getId();
	}
	
	private GameEntity convert(GameDTO input) {
		GameEntity game = new GameEntity();
		game.setGameName(input.getGameName());
		game.setMaxAttempts(input.getMaxAttempts());
		game.setQuestionAnswer(input.getGameAnswer());
		return game;
	}

}
