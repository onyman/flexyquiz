package com.flexyquiz.app.client.func.manage.quiz;

import com.flexyquiz.app.client.core.mvp.BaseActivity;
import com.flexyquiz.app.client.core.mvp.BasePlace;
import com.flexyquiz.app.client.core.mvp.PlaceWithName;

@PlaceWithName(name = "editquestion")
public class EditQuestionsPlace extends BasePlace {
  private String quizId;

  public EditQuestionsPlace() {
  }

  public EditQuestionsPlace(String quizId) {
    this.quizId = quizId;
  }

  @Override
  public BaseActivity getActivity() {
    return new EditQuestionsActivity(quizId);
  }

  @Override
  public String getToken() {
    return "" + quizId;
  }

  @Override
  public void init(String token) {
    this.quizId = token;
  }
}
