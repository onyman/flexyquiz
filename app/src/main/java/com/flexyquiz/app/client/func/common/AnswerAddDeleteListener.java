package com.flexyquiz.app.client.func.common;

public interface AnswerAddDeleteListener {
  void addAnswer(int afterIndex);

  void deleteAnswer(int answerIndex);
}
