package com.flexyquiz.app.client.func.manage.quiz;

import com.flexyquiz.app.client.core.mvp.BaseActivity;
import com.flexyquiz.app.client.core.mvp.BasePlace;
import com.flexyquiz.app.client.core.mvp.PlaceWithName;

@PlaceWithName(name="listquiz")
public class ListQuizPlace extends BasePlace {
  public ListQuizPlace() {
    super("Edit quizzes");
  }

  @Override
  public BaseActivity getActivity() {
    return new ListQuizActivity();
  }
}
