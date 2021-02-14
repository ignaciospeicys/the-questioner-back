package com.nicoynacho.questioner.manager;

import com.nicoynacho.questioner.dto.GameAnswerDTO;
import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.exception.subtype.ElementNotFoundException;

public interface IGameManager {
	
	Long create(GameDTO input);
	
	GameDTO find(Long gameId) throws ElementNotFoundException;

	GameAnswerDTO checkAnswer(Long gameId, GameDTO inputGame) throws ElementNotFoundException;

}
