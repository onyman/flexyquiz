package com.flexyquiz.app.client.core.widget;

import com.flexyquiz.app.shared.core.model.HasDisplayName;
import com.google.gwt.text.shared.AbstractRenderer;

public class EnumRenderer<T extends HasDisplayName> extends AbstractRenderer<T> {
  private String emptyValue = "";

  @Override
  public String render(T object) {
    if (object == null) return emptyValue;
    return object.getDisplayName();
  }

  public void setEmptyValue(String emptyValue) {
    this.emptyValue = emptyValue;
  }
}
