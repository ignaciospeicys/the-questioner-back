package com.nicoynacho.questioner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionDTO {
	
	@JsonProperty("game_id")
	private Long gameId;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("answer")
	private String answer;

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
