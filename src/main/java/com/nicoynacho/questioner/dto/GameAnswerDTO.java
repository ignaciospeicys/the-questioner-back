package com.nicoynacho.questioner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameAnswerDTO {
	
	@JsonProperty("game_answer")
	private String answer;
	
	@JsonProperty("answer_accepted")
	private boolean accepted;

	public GameAnswerDTO(boolean match, String questionAnswer) {
		this.answer = questionAnswer;
		this.accepted = match;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
}
