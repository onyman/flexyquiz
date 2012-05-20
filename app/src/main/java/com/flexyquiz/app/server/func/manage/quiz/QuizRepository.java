package com.flexyquiz.app.server.func.manage.quiz;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flexyquiz.app.shared.func.model.QuizImpl;

public interface QuizRepository extends MongoRepository<QuizImpl, String> {
}
