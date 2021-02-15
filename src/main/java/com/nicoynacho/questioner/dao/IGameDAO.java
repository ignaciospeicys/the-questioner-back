package com.nicoynacho.questioner.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nicoynacho.questioner.entity.GameEntity;

@Repository
public interface IGameDAO extends PagingAndSortingRepository<GameEntity, Long> {

	List<GameEntity> findAll();
}
