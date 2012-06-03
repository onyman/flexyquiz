package com.flexyquiz.app.client.func.common;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;

public class HeaderWidget extends Composite {
  private HTML widget = new HTML();

  private String title;
  
  public @UiConstructor
  HeaderWidget(String title) {
    this.title = title;
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
  
  public void setTitleAndMessage(String title, String message) {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul class='breadcrumb'>");
    sb.append("<li>").append("<div class='label label-success'>").append(message).append("</div>").append("</li>");
    sb.append("<li>").append("&nbsp;").append("</li>");
    sb.append("<li class='active'>").append(title).append("</li>");
    sb.append("</ul>");

    widget.setHTML(sb.toString());
    
  }
  
  public void showTempMessage(String message) {
    setTitleAndMessage(title, message);
    Timer timer = new Timer() {
      @Override
      public void run() {
        setTitle(title);
      }
    };
    timer.schedule(5000);
  }
}
