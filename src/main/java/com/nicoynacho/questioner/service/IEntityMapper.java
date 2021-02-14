package com.nicoynacho.questioner.service;

import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.entity.GameEntity;

/**
 * Converts Entities to DTOs and back
 */
public interface IEntityMapper {
	
	GameEntity convert(GameDTO input);
	
	GameDTO convert(GameEntity entity);

}
