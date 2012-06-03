package com.flexyquiz.app.client.func.common;

import java.util.ArrayList;
import java.util.List;

import com.flexyquiz.app.shared.func.model.Answer;
import com.flexyquiz.app.shared.func.model.AnswerImpl;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class AnswersWidget extends Composite implements AnswerAddDeleteListener {
  private HTMLPanel contentPanel = new HTMLPanel("");

  private List<AnswerWidget> answerWidgets;

  private AnswersWidget() {
    initWidget(contentPanel);
  }

  public void setData(List<Answer> answers) {
    answerWidgets = new ArrayList<AnswerWidget>(answers.size());
    contentPanel.clear();
    for (int i = 0; i < answers.size(); i++) {
      AnswerWidget answerWidget = new AnswerWidget(i, this);
      answerWidget.setData(answers.get(i));
      answerWidgets.add(answerWidget);
      contentPanel.add(answerWidget);
    }
  }

  public List<Answer> getData() {
    List<Answer> answers = new ArrayList<Answer>(answerWidgets.size());
    for (AnswerWidget widget : answerWidgets) {
      answers.add(widget.getData());
    }
    return answers;
  }

  public void addAnswer(int afterIndex) {
    List<Answer> answers = getData();
    answers.add(afterIndex + 1, new AnswerImpl());
    setData(answers);
  }

  public void deleteAnswer(int answerIndex) {
    List<Answer> answers = getData();
    if (answers.size() == 1) return;
    answers.remove(answerIndex);
    setData(answers);
  }
}
