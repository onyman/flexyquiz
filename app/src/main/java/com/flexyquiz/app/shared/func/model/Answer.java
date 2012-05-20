package com.flexyquiz.app.shared.func.model;

import com.flexyquiz.app.shared.core.model.Persistent;

public interface Answer extends Persistent {
  boolean isCorrect();

  String getAnswerText();

  void setCorrect(boolean correct);

  void setAnswerText(String answerText);
}