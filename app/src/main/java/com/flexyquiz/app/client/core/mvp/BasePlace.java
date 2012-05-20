package com.flexyquiz.app.client.core.mvp;

import com.google.gwt.place.shared.Place;

public abstract class BasePlace extends Place {
  private String displayName;
  
  public BasePlace(String displayName) {
    this.displayName = displayName;
  }
  
  public BasePlace() {
    String[] classNameElements = getClass().getName().split("\\.");
    this.displayName = classNameElements[classNameElements.length - 1];
  }
  
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public abstract BaseActivity getActivity();
  
  public String getToken() {
    return null;
  }
  
  public void init(String token) {
    
  }
}
