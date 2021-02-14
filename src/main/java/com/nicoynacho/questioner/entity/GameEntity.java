package com.nicoynacho.questioner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nicoynacho.questioner.enums.GameCategoryEnum;

@Entity
@Table(name = "QUESTIONER_GAME")
public class GameEntity {
	
	@Id
	@Column(name = "game_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "game_name")
	private String gameName;
	
	@Column(name = "max_attempts")
	private int maxAttempts;
	
	@Column(name = "question_answer")
	private String questionAnswer;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "game_category")
	private GameCategoryEnum category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public GameCategoryEnum getCategory() {
		return category;
	}

	public void setCategory(GameCategoryEnum category) {
		this.category = category;
	}
}
