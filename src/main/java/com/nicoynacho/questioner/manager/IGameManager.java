package com.nicoynacho.questioner.manager;

import java.util.List;

import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.entity.GameEntity;
import com.nicoynacho.questioner.exception.subtype.ElementNotFoundException;

public interface IGameManager {
	
	Long create(GameDTO input);
	
	GameDTO findAndConvert(Long gameId) throws ElementNotFoundException;

	GameEntity get(Long id) throws ElementNotFoundException;

	List<GameDTO> findAll();

}
