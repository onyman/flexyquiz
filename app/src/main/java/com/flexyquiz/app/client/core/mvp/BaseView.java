package com.flexyquiz.app.client.core.mvp;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public abstract class BaseView extends Composite implements BaseDisplay {
  public Widget getViewWidget() {
    return asWidget();
  }
}
