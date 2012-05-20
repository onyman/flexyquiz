package com.flexyquiz.app.client.core.widget.dialog;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Dialog {
  private Dialog() {
  }
  
  public static final void showMessageDialog(String title, String message) {
    showMessageDialog(title, message, Type.DEFAULT);
  }
  
  public static final void showMessageDialog(String title, String message, Type type) {
    Button closeButton = new Button("Close");
    closeButton.setStyleName("btn btn-primary");

    final DialogBox dialogBox = createDialog(title, message, type, closeButton);
    
    closeButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        dialogBox.hide();
      }
    });
    
    dialogBox.center();
    closeButton.setFocus(true);
  }
  
  public static final void showConfirmationDialog(String title, String message, 
      final ConfirmationDialogEventHandler eventHandler) {
    Button yesButton = new Button("Yes");
    yesButton.setStyleName("btn");
    
    Button noButton = new Button("No");
    noButton.setStyleName("btn btn-primary");
    
    final DialogBox dialogBox = createDialog(title, message, Type.IMPORTANT, yesButton, noButton);
    
    yesButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        new ConfirmationDialogEvent(true).dispatch(eventHandler);
        dialogBox.hide();
      }
    });
    noButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        new ConfirmationDialogEvent(false).dispatch(eventHandler);
        dialogBox.hide();
      }
    });
    
    dialogBox.center();
    noButton.setFocus(true);
  }
  
  private static final DialogBox createDialog(String title, String message, Type type, Button... buttons) {
    final DialogBox dialogBox = new DialogBox();
    dialogBox.setText(title);
    dialogBox.setAnimationEnabled(true);
    dialogBox.setModal(true);
    dialogBox.setStyleName("label label-" + type.getStyleName() + " dialog");
    
    VerticalPanel contentPanel = new VerticalPanel();
    contentPanel.setStyleName("dialog-content");

    HTML messageLabel = new HTML(message);
    ScrollPanel scrollPanel = new ScrollPanel(messageLabel);
    scrollPanel.setStyleName("dialog-message");
    contentPanel.add(scrollPanel);
    
    HorizontalPanel buttonsPanel = new HorizontalPanel();
    buttonsPanel.setStyleName("dialog-buttons-panel");
    for (Button button : buttons) {
      buttonsPanel.add(button);
    }
    contentPanel.add(buttonsPanel);
        
    dialogBox.setWidget(contentPanel);
    
    return dialogBox;
  }
  
  public static enum Type {
    DEFAULT("na"), SUCCESS("success"), WARNING("warning"), IMPORTANT("important"), INFO("info"), INVESRSE("inverse");
    
    private String styleName;

    private Type(String styleName) {
      this.styleName = styleName;
    }

    private String getStyleName() {
      return styleName;
    }
  }
}
