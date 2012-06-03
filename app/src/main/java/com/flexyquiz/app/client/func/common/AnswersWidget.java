package com.flexyquiz.app.client.func.common;

import java.util.List;

import com.flexyquiz.app.shared.func.model.Answer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class AnswersWidget extends Composite {
  // private VerticalPanel contentPanel = new VerticalPanel();
  private HTMLPanel contentPanel = new HTMLPanel("<div></div>");

  private AnswersWidget() {
    initWidget(contentPanel);
  }

  public void setData(List<Answer> answers) {
    contentPanel.clear();
    for (int i = 0; i < answers.size(); i++) {
      AnswerWidget answerWidget = new AnswerWidget();
      answerWidget.setData(answers.get(i));
      contentPanel.add(answerWidget);
    }
  }

  private void addAnswer(int i) {
    // TODO
  }

  private void deleteAnswer(int i) {
    // TODO
  }

  public List<Answer> getData() {
    return null;
  }
}
