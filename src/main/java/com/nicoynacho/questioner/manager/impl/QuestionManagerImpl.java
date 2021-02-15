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
		String username = input.getUsername();
		String inputAnswer = input.getAnswer();
		GameAnswerDTO gameAnswer = new GameAnswerDTO();
		GameEntity game = gameManager.get(input.getGameId());
		QuestionEntity entity = new QuestionEntity(username, inputAnswer, game);
		questionDAO.save(entity);
		String originalAnswer = game.getQuestionAnswer();
		checkOutOfGame(gameAnswer, username, game);
		checkAnswer(gameAnswer, originalAnswer, inputAnswer);	
		return gameAnswer;
	}
	
	private void checkOutOfGame(GameAnswerDTO answer, String username, GameEntity game) {
		int count = questionDAO.countByUsernameAndGameId(username, game.getId());
		if (count > game.getMaxAttempts())
			answer.setOutOfGame(true);
	}
	
	private void checkAnswer(GameAnswerDTO answer, String originalAnswer, String inputAnswer) {
		boolean match = QuestionerAnswerMatcher.doAnswersMatch(originalAnswer, inputAnswer);
		answer.setAccepted(match);
		answer.setAnswer(match ? originalAnswer : inputAnswer);
	}

}
