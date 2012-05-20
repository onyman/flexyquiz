package com.flexyquiz.app.client.core.mvp;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public abstract class BaseActivity extends AbstractActivity {
  private PlaceController placeController = PlaceControllerSingleton.getInstnace();
  private ViewRegistry viewRegistry = GWT.create(GeneratedViewRegistry.class);
  
  protected BaseDisplay baseDisplay;
  
  public BaseActivity() {
    this.baseDisplay = viewRegistry.getView(this);
  }

  protected void goTo(Place newPlace) {
    placeController.goTo(newPlace);
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    bind();
    container.setWidget(baseDisplay.getViewWidget());
    onStart();
  }

  protected void bind() {
  }

  protected void onStart() {
  }
}
