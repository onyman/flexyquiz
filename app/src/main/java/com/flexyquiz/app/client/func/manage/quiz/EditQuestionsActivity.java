package com.flexyquiz.app.client.func.manage.quiz;

import java.util.List;

import com.flexyquiz.app.client.core.mvp.BaseActivity;
import com.flexyquiz.app.client.core.mvp.BaseDisplay;
import com.flexyquiz.app.client.core.rpc.ErrorHandlingAsyncCallback;
import com.flexyquiz.app.shared.func.model.Question;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;

public class EditQuestionsActivity extends BaseActivity {
  public interface Display extends BaseDisplay {
    public HasClickHandlers getButtonBack();

    public HasClickHandlers getButtonSave();

    public HasClickHandlers getButtonSaveAndNext();

    public HasClickHandlers getButtonAdd();

    public HasClickHandlers getButtonDelete();

    public void setData(Question quiz);

    public Question getData();
  }

  private QuizRpcServiceAsync quizRpcService = QuizRpcServiceAsync.Util.getInstance();

  private String quizId;
  private List<? extends Question> questions;
  private int currentQuestionIndex = -1;

  public EditQuestionsActivity(String quizId) {
    this.quizId = quizId;
    quizRpcService.getQuestions(quizId, new ErrorHandlingAsyncCallback<List<? extends Question>>() {
      public void onSuccess(List<? extends Question> result) {
        questions = result;
        currentQuestionIndex = 0;
        display().setData(questions.get(currentQuestionIndex));
      }
    });
  }
  
  @Override
  protected void bind() {
    display().getButtonBack().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        goTo(new ListQuizPlace());
      }
    });
  }

  private Display display() {
    return (Display) baseDisplay;
  }
}
