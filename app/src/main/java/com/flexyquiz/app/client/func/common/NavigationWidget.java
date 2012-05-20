package com.flexyquiz.app.client.func.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flexyquiz.app.client.core.mvp.BasePlace;
import com.flexyquiz.app.client.core.mvp.GeneratedPlaceHistoryMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;

public class NavigationWidget extends Composite {
  private Map<String, List<BasePlace>> navTree = new HashMap<String, List<BasePlace>>();
  private List<String> orderedNavTreeGroups = new ArrayList<String>();

  private PlaceHistoryMapper placeHistoryMapper = GWT.create(GeneratedPlaceHistoryMapper.class);

  protected void buildWidget(BasePlace currentPlace) {
    final String currentPlaceToken = currentPlace == null ? null : placeHistoryMapper.getToken(currentPlace);
    
    HTML html = new HTML();

    StringBuilder sb = new StringBuilder();
    sb.append("<ul class='nav nav-list'>");

    for (String groupTitle : orderedNavTreeGroups) {
      sb.append("<li class='nav-header'>").append(groupTitle).append("</li>");
      List<BasePlace> placesInGroup = navTree.get(groupTitle);
      for (BasePlace place : placesInGroup) {
        String token = placeHistoryMapper.getToken(place);
        if (token.equals(currentPlaceToken)) {
          sb.append("<li class='active'><a href='#").append(token).append("'>").append(place.getDisplayName())
              .append("</a></li>");
        } else {
          sb.append("<li><a href='#").append(token).append("'>").append(place.getDisplayName()).append("</a></li>");
        }
      }
    }

    sb.append("</ul>");

    html.setHTML(sb.toString());

    initWidget(html);
  }

  public void addNavGroup(String title, BasePlace... places) {
    orderedNavTreeGroups.add(title);
    navTree.put(title, Arrays.asList(places));
  }
}
