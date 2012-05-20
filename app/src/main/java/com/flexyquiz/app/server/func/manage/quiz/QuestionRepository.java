package com.flexyquiz.app.server.func.manage.quiz;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flexyquiz.app.shared.func.model.QuestionImpl;

public interface QuestionRepository extends MongoRepository<QuestionImpl, String> {
  List<QuestionImpl> findByQuizId(String quizId);
}
