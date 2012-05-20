package com.flexyquiz.app.client.func.manage.home;

import com.flexyquiz.app.client.core.mvp.BaseView;
import com.flexyquiz.app.client.core.mvp.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

@View(forActivity = HomeActivity.class)
public class HomeView extends BaseView implements HomeActivity.Display {
  interface HomeViewUiBinder extends UiBinder<Widget, HomeView> {
  }

  private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);

  public HomeView() {
    initWidget(uiBinder.createAndBindUi(this));
  }
}
