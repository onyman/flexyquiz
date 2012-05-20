package com.flexyquiz.app.client.core.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class ErrorHandlingAsyncCallback<T> implements AsyncCallback<T> {
  public void onFailure(Throwable caught) {
    GWT.getUncaughtExceptionHandler().onUncaughtException(caught);
  }
}
