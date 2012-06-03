package com.flexyquiz.app.client.func.common;

import com.flexyquiz.app.shared.func.model.Answer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AnswerWidget extends Composite {
  interface AnswerWidgetUiBinder extends UiBinder<Widget, AnswerWidget> {
  }

  private AnswerWidgetUiBinder uiBinder = GWT.create(AnswerWidgetUiBinder.class);

  private Answer answer;

  @UiField
  TextBox answerText;

  @UiField
  Button buttonDelete;

  @UiField
  Button buttonAdd;

  public AnswerWidget() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  public void setData(Answer answer) {
    this.answer = answer;
    answerText.setText(answer.getAnswerText());
  }

  public Answer getData() {
    answer.setAnswerText(answerText.getText());
    return answer;
  }
}
