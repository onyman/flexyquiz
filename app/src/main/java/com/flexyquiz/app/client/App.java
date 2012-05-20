package com.flexyquiz.app.client;

import com.flexyquiz.app.client.core.UncaughtExceptionHandlerWithDialog;
import com.flexyquiz.app.client.core.mvp.GeneratedPlaceHistoryMapper;
import com.flexyquiz.app.client.core.mvp.PlaceControllerSingleton;
import com.flexyquiz.app.client.core.mvp.SimpleActivityMapper;
import com.flexyquiz.app.client.func.manage.home.HomePlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

public class App implements EntryPoint {
  public void onModuleLoad() {
    GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandlerWithDialog());
    
    // some boilerplate code to start the activity/place GWT framework...
    final SimplePanel appWidget = new SimplePanel();

    // start activity manager for our main widget with our ActivityMapper
    EventBus eventBus = new SimpleEventBus();
    ActivityMapper activityMapper = new SimpleActivityMapper();
    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
    activityManager.setDisplay(appWidget);
    
    // start PlaceHistoryHandler with our PlaceHistoryMapper
    PlaceHistoryMapper historyMapper = GWT.create(GeneratedPlaceHistoryMapper.class);
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    PlaceController placeController = new PlaceControllerSingleton(eventBus);
    historyHandler.register(placeController, eventBus, new HomePlace());

    RootPanel.get("main").add(appWidget);

    historyHandler.handleCurrentHistory();
  }
}
