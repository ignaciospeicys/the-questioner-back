package com.nicoynacho.questioner.service;

import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.dto.QuestionDTO;
import com.nicoynacho.questioner.entity.GameEntity;
import com.nicoynacho.questioner.entity.QuestionEntity;

/**
 * Converts Entities to DTOs and back
 */
public interface IEntityMapper {
	
	GameEntity convert(GameDTO input);
	
	GameDTO convert(GameEntity entity);

	QuestionDTO convert(QuestionEntity entity);

}
