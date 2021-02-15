package com.nicoynacho.questioner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameAnswerDTO {
	
	@JsonProperty("game_answer")
	private String answer;
	
	@JsonProperty("answer_accepted")
	private boolean accepted;
	
	@JsonProperty("out_of_game")
	private boolean outOfGame;
	
	public GameAnswerDTO() {
	}

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

	public boolean isOutOfGame() {
		return outOfGame;
	}

	public void setOutOfGame(boolean outOfGame) {
		this.outOfGame = outOfGame;
	}
}
