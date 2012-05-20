package com.flexyquiz.app.client.core.mvp;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public class PlaceControllerSingleton extends PlaceController {
  private static PlaceControllerSingleton instance;

  public PlaceControllerSingleton(EventBus eventBus) {
    super(eventBus);
    if (instance == null) {
      instance = this;
    } else {
      throw new RuntimeException("Place controller is already initialized! Use getInstance() instead");
    }
  }

  public static PlaceControllerSingleton getInstnace() {
    return instance;
  }
}
