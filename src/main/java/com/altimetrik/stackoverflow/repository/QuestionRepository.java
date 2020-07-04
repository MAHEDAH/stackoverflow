package com.altimetrik.stackoverflow.repository;

import org.springframework.data.repository.CrudRepository;

import com.altimetrik.stackoverflow.domain.Question;

public interface QuestionRepository extends CrudRepository<Question,Long> {

}
