package com.nicoynacho.questioner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameDTO {
	
	@JsonProperty("game_name")
	private String gameName;
	
	@JsonProperty("max_attempts")
	private int maxAttempts;
	
	@JsonProperty("game_answer")
	private String gameAnswer;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getMaxAttempts() {
		return maxAttempts;
	}

	public void setMaxAttempts(int maxAttempts) {
		this.maxAttempts = maxAttempts;
	}

	public String getGameAnswer() {
		return gameAnswer;
	}

	public void setGameAnswer(String gameAnswer) {
		this.gameAnswer = gameAnswer;
	}
}
