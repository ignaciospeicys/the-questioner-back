package com.nicoynacho.questioner.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicoynacho.questioner.dao.IQuestionDAO;
import com.nicoynacho.questioner.dto.GameAnswerDTO;
import com.nicoynacho.questioner.dto.QuestionDTO;
import com.nicoynacho.questioner.entity.GameEntity;
import com.nicoynacho.questioner.entity.QuestionEntity;
import com.nicoynacho.questioner.exception.subtype.ElementNotFoundException;
import com.nicoynacho.questioner.manager.IGameManager;
import com.nicoynacho.questioner.manager.IQuestionManager;
import com.nicoynacho.questioner.util.QuestionerAnswerMatcher;

@Service
public class QuestionManagerImpl implements IQuestionManager {
	
	@Autowired
	private IQuestionDAO questionDAO;
	
	@Autowired
	private IGameManager gameManager;
	
	@Override
	public GameAnswerDTO submitAnswer(QuestionDTO input) throws ElementNotFoundException {
		GameEntity game = gameManager.get(input.getGameId());
		String inputAnswer = input.getAnswer();
		QuestionEntity entity = new QuestionEntity(input.getUsername(), inputAnswer, game);
		questionDAO.save(entity);
		String originalAnswer = game.getQuestionAnswer();
		return checkAnswer(originalAnswer, inputAnswer);
	}
	
	private GameAnswerDTO checkAnswer(String originalAnswer, String inputAnswer) {
		boolean match = QuestionerAnswerMatcher.doAnswersMatch(originalAnswer, inputAnswer);
		return match ? new GameAnswerDTO(match, originalAnswer) : new GameAnswerDTO(match, inputAnswer);
	}

}
