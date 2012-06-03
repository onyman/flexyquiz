package com.flexyquiz.app.shared.func.model;

import java.util.List;

import com.flexyquiz.app.shared.core.model.Persistent;

public interface Question extends Persistent {
  String getQuizId();

  String getQuestionText();

  QuestionType getType();

  List<Answer> getAnswers();

  String getExplanation();

  void setQuizId(String quizId);

  void setQuestionText(String questionText);

  void setType(QuestionType type);

  void setAnswers(List<Answer> answers);

  void setExplanation(String explanation);
}