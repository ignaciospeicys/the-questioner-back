package com.nicoynacho.questioner.manager.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicoynacho.questioner.dao.IGameDAO;
import com.nicoynacho.questioner.dto.GameDTO;
import com.nicoynacho.questioner.entity.GameEntity;
import com.nicoynacho.questioner.exception.subtype.ElementNotFoundException;
import com.nicoynacho.questioner.manager.IGameManager;
import com.nicoynacho.questioner.service.IEntityMapper;

@Service
public class GameManagerImpl implements IGameManager {
	
	@Autowired
	private IGameDAO gameDAO;
	
	@Autowired
	private IEntityMapper mapper;

	@Override
	public Long create(GameDTO input) {
		GameEntity game = mapper.convert(input);
		gameDAO.save(game);
		return game.getId();
	}
	
	@Override
	public GameEntity get(Long id) throws ElementNotFoundException {
		Optional<GameEntity> game = gameDAO.findById(id);
		if (!game.isPresent())
			throw new ElementNotFoundException("The requested game does not exist");
		return game.get();
	}
	
	@Override
	public GameDTO findAndConvert(Long gameId) throws ElementNotFoundException {
		GameEntity game = get(gameId);
		return mapper.convert(game);
	}
	
	@Override
	public List<GameDTO> findAll() {
		return gameDAO.findAll().stream().map(mapper::convert).collect(Collectors.toList());
	}


}
