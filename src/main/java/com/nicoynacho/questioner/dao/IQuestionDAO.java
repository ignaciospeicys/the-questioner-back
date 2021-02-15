package com.nicoynacho.questioner.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nicoynacho.questioner.entity.QuestionEntity;

@Repository
public interface IQuestionDAO extends PagingAndSortingRepository<QuestionEntity, Long>{

}
