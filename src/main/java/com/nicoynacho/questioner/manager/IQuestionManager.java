package com.nicoynacho.questioner.manager;

import com.nicoynacho.questioner.dto.GameAnswerDTO;
import com.nicoynacho.questioner.dto.QuestionDTO;
import com.nicoynacho.questioner.exception.subtype.ElementNotFoundException;

public interface IQuestionManager {

	GameAnswerDTO submitAnswer(QuestionDTO input) throws ElementNotFoundException;
}
