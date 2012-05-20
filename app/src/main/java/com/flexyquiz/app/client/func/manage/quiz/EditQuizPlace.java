package com.flexyquiz.app.client.func.manage.quiz;

import com.flexyquiz.app.client.core.mvp.BaseActivity;
import com.flexyquiz.app.client.core.mvp.BasePlace;
import com.flexyquiz.app.client.core.mvp.PlaceWithName;

@PlaceWithName(name="editquiz")
public class EditQuizPlace extends BasePlace {
  private String quizId;

  public EditQuizPlace() {
    super("Add quiz");
  }

  public EditQuizPlace(String quizId) {
    this.quizId = quizId;
  }

  @Override
  public String getToken() {
    return quizId == null ? null : quizId;
  }

  @Override
  public void init(String token) {
      quizId = token;
  }

  @Override
  public BaseActivity getActivity() {
    return new EditQuizActivity(quizId);
  }
}
