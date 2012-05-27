package com.flexyquiz.app.client.func.manage.quiz;

import com.flexyquiz.app.client.core.mvp.BaseActivity;
import com.flexyquiz.app.client.core.mvp.BasePlace;
import com.flexyquiz.app.client.core.mvp.PlaceWithName;

@PlaceWithName(name = "editquestion")
public class EditQuestionsPlace extends BasePlace {
  private String quizId;
  private int questionNumber = 0;

  public EditQuestionsPlace() {
  }

  public EditQuestionsPlace(String quizId) {
    this.quizId = quizId;
  }

  @Override
  public BaseActivity getActivity() {
    return new EditQuestionsActivity(quizId, questionNumber);
  }

  @Override
  public String getToken() {
    return "" + quizId;
  }

  @Override
  public void init(String token) {
    String[] tokens = token.split(":", 2);
    if (tokens.length == 1) {
      this.quizId = token;
    } else {
      this.quizId = tokens[0];
      this.questionNumber = Integer.parseInt(tokens[1]) - 1;
    }
  }
}
