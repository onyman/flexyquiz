package com.flexyquiz.app.client.core.widget.dialog;

import com.google.gwt.event.shared.GwtEvent;

public class ConfirmationDialogEvent extends GwtEvent<ConfirmationDialogEventHandler> {
  private boolean confirmed;

  public ConfirmationDialogEvent(boolean confirmed) {
    this.confirmed = confirmed;
  }

  public boolean isConfirmed() {
    return confirmed;
  }

  @Override
  public com.google.gwt.event.shared.GwtEvent.Type<ConfirmationDialogEventHandler> getAssociatedType() {
    return null; // it is not used as real GWT event for now - don't care about
                 // GWT event types
  }

  @Override
  protected void dispatch(ConfirmationDialogEventHandler handler) {
    handler.onConfirmation(this);
  }
}
