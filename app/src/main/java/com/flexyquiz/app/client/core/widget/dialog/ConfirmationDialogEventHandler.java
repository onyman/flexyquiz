package com.flexyquiz.app.client.core.widget.dialog;

import com.google.gwt.event.shared.EventHandler;

public interface ConfirmationDialogEventHandler extends EventHandler {

  void onConfirmation(ConfirmationDialogEvent confirmationDialogEvent);
}
