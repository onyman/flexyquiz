package com.flexyquiz.app.shared.func.model;

import com.flexyquiz.app.shared.core.model.AbstractPersistent;

public class AnswerImpl extends AbstractPersistent implements Answer {
  private boolean correct;
  private String answerText;

  public boolean isCorrect() {
    return correct;
  }

  public String getAnswerText() {
    return answerText;
  }

  public void setCorrect(boolean correct) {
    this.correct = correct;
  }

  public void setAnswerText(String answerText) {
    this.answerText = answerText;
  }
}
