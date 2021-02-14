package com.nicoynacho.questioner.service.impl;

import org.springframework.stereotype.Service;

import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.entity.GameEntity;
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
		game.setCategory(GameCategoryEnum.findByName(input.getGameCategory()));
		return game;
	}

	@Override
	public GameDTO convert(GameEntity entity) {
		GameDTO game = new GameDTO();
		game.setGameName(entity.getGameName());
		game.setGameCategory(entity.getCategory().name());
		game.setMaxAttempts(entity.getMaxAttempts());
		return game;
	}

}
