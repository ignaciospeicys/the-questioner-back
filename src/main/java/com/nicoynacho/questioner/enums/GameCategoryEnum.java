package com.nicoynacho.questioner.enums;

public enum GameCategoryEnum {
	
	CINEMA,
	SPORTS,
	TV,
	VIDEO_GAMES,
	SCIENCE,
	HISTORY,
	OTHER;
	
	public static GameCategoryEnum findByName(String name) {
		for (GameCategoryEnum category : values()) {
			if (category.name().equalsIgnoreCase(name))
				return category;
		}
		return OTHER;
	}

}
