package com.flexyquiz.app.client.func.common;

import com.flexyquiz.app.client.func.manage.home.HomePlace;
import com.flexyquiz.app.client.func.manage.quiz.EditQuizPlace;
import com.flexyquiz.app.client.func.manage.quiz.ListQuizPlace;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.Window;

public class ManagementNavigationWidget extends NavigationWidget {
  public ManagementNavigationWidget() {
    addNavGroup("Manage Quiz", new EditQuizPlace(), new ListQuizPlace());
    addNavGroup("Sample", new HomePlace());
    buildWidget(null);
  }

  @UiChild(tagname = "message")
  public void addChild(Object child) {
    Window.alert(child.getClass().getName());
  }
}
