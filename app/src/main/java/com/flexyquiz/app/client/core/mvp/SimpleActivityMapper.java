package com.flexyquiz.app.client.core.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class SimpleActivityMapper implements ActivityMapper {
  @Override
  public Activity getActivity(Place place) {
    if (place instanceof BasePlace) {
      return ((BasePlace) place).getActivity();
    }
    return null;
  }
}
