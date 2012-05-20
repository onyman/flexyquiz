package com.flexyquiz.app.client.core;

import com.flexyquiz.app.client.core.util.ExceptionsUtil;
import com.flexyquiz.app.client.core.widget.dialog.Dialog;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;

public class UncaughtExceptionHandlerWithDialog implements UncaughtExceptionHandler {
  public void onUncaughtException(Throwable e) {
    String message = GWT.isProdMode() ? e.getMessage() : "<pre>" + ExceptionsUtil.throwableToString(e) + "</pre>";
    Dialog.showMessageDialog("Error", message, Dialog.Type.WARNING);
  }  
}
