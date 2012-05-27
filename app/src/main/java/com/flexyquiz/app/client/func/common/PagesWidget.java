package com.flexyquiz.app.client.func.common;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;

public class PagesWidget extends Composite {
  private HTML innerHtml = new HTML("<div>Not yet initialized</div>");

  public PagesWidget() {
    initWidget(innerHtml);
  }

  public void update(int pagesCount, int currentPage) {
    StringBuilder sb = new StringBuilder();
    sb.append("<div class='pagination'><ul class='pages'>");
    for (int i = 1; i <= pagesCount; i++) {
      String styleClass = currentPage == i ? "active" : "notactive";
      sb.append("<li class='" + styleClass + "'><a href='#" + History.getToken() + ":" + i + "'>" + i + "</a></li>");
    }
    sb.append("</ul></div>");
    innerHtml.setHTML(sb.toString());
  }
}
