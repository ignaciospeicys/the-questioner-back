package com.nicoynacho.questioner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONER_GAME")
public class GameEntity {
	
	@Id
	@Column(name = "game_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "game_name")
	private String gameName;
	
	@Column(name = "max_attempts")
	private int maxAttempts;
	
	@Column(name = "question_answer")
	private String questionAnswer;

}
