package com.flexyquiz.app.client.func.manage.quiz;

import com.flexyquiz.app.client.core.mvp.BaseActivity;
import com.flexyquiz.app.client.core.mvp.BaseDisplay;
import com.flexyquiz.app.client.core.mvp.BasePlace;
import com.flexyquiz.app.client.core.rpc.ErrorHandlingAsyncCallback;
import com.flexyquiz.app.client.core.widget.dialog.ConfirmationDialogEvent;
import com.flexyquiz.app.client.core.widget.dialog.ConfirmationDialogEventHandler;
import com.flexyquiz.app.client.core.widget.dialog.Dialog;
import com.flexyquiz.app.shared.func.model.Quiz;
import com.flexyquiz.app.shared.func.model.QuizImpl;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;

public class EditQuizActivity extends BaseActivity {
  public interface Display extends BaseDisplay {
    public HasClickHandlers getCancelButton();

    public HasClickHandlers getSaveButton();

    public HasClickHandlers getDeleteButton();

    public HasClickHandlers getEditQuestionsButton();

    public void setData(Quiz quiz);

    public Quiz getData();
  }

  private QuizRpcServiceAsync quizRpcService = QuizRpcServiceAsync.Util.getInstance();

  public EditQuizActivity(String quizId) {
    if (quizId != null) {
      quizRpcService.getById(quizId, new ErrorHandlingAsyncCallback<Quiz>() {
        public void onSuccess(Quiz result) {
          display().setData(result);
        }
      });
    } else {
      display().setData(new QuizImpl());
    }
  }

  @Override
  protected void bind() {
    display().getCancelButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        goTo(new ListQuizPlace());
      }
    });
    display().getSaveButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        saveQuiz();
      }
    });
    display().getDeleteButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        askToDeleteQuiz();
      }
    });
    display().getEditQuestionsButton().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        editQuestions();
      }
    });
  }

  private Display display() {
    return (Display) baseDisplay;
  }

  private void saveQuiz() {
    quizRpcService.save(display().getData(), new ErrorHandlingAsyncCallback<Quiz>() {
      public void onSuccess(Quiz result) {
        goTo(new ListQuizPlace());
      }
    });
  }

  private void editQuestions() {
    quizRpcService.save(display().getData(), new ErrorHandlingAsyncCallback<Quiz>() {
      public void onSuccess(Quiz result) {
        goTo(new EditQuestionsPlace(result.getId()));
      }
    });
  }

  private void askToDeleteQuiz() {
    String message = "Are you sure you want to trash this quiz?";
    Dialog.showConfirmationDialog("Delete?", message, new ConfirmationDialogEventHandler() {
      public void onConfirmation(ConfirmationDialogEvent confirmationDialogEvent) {
        if (confirmationDialogEvent.isConfirmed()) {
          deleteQuiz();
        }
      }
    });
  }

  private void deleteQuiz() {
    quizRpcService.delete(display().getData(), new ErrorHandlingAsyncCallback<Void>() {
      public void onSuccess(Void result) {
        goTo(new ListQuizPlace());
      }
    });
  }
}
