package com.flexyquiz.app.client.func.manage.home;

import com.flexyquiz.app.client.core.mvp.BaseActivity;
import com.flexyquiz.app.client.core.mvp.BasePlace;
import com.flexyquiz.app.client.core.mvp.PlaceWithName;

@PlaceWithName(name = "start")
public class HomePlace extends BasePlace {
  public HomePlace() {
    super();
  }

  @Override
  public BaseActivity getActivity() {
    return new HomeActivity();
  }
}
