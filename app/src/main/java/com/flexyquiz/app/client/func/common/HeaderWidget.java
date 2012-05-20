package com.flexyquiz.app.client.func.common;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;

public class HeaderWidget extends Composite {
  private HTML widget = new HTML();

  public @UiConstructor
  HeaderWidget(String title) {
    setTitle(title);
    initWidget(widget);
  }

  public void setTitle(String title) {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul class='breadcrumb'>");
    sb.append("<li class='active'>").append(title).append("</li>");
    sb.append("</ul>");

    widget.setHTML(sb.toString());
  }
}
