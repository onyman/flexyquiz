package com.flexyquiz.app.shared.func.model;

import com.flexyquiz.app.shared.core.model.HasDisplayName;

public enum QuestionType implements HasDisplayName{
  ONE_CORRECT_ANSWER("One correct answer"), 
  MULTIPLE_CORRECT_ANSWERS("Multiple correct answers"), 
  TEXT_INPUT("Text input");
  
  private String displayName;

  private QuestionType(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}
