package com.flexyquiz.app.client.func.manage.quiz;

import java.util.ArrayList;
import java.util.List;

import com.flexyquiz.app.client.core.mvp.BaseActivity;
import com.flexyquiz.app.client.core.mvp.BaseDisplay;
import com.flexyquiz.app.client.core.rpc.ErrorHandlingAsyncCallback;
import com.flexyquiz.app.client.core.widget.dialog.ConfirmationDialogEvent;
import com.flexyquiz.app.client.core.widget.dialog.ConfirmationDialogEventHandler;
import com.flexyquiz.app.client.core.widget.dialog.Dialog;
import com.flexyquiz.app.shared.func.model.Answer;
import com.flexyquiz.app.shared.func.model.AnswerImpl;
import com.flexyquiz.app.shared.func.model.Question;
import com.flexyquiz.app.shared.func.model.QuestionImpl;
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

    public void setData(Question quiz, int totalQuestions, int currentQuestion);

    public Question getData();
    
    public void showMessage(String message);
  }

  private QuizRpcServiceAsync quizRpcService = QuizRpcServiceAsync.Util.getInstance();

  private String quizId;
  private List<Question> questions;
  private int currentQuestionIndex;

  public EditQuestionsActivity(final String quizId, int questionNumber) {
    this.quizId = quizId;
    currentQuestionIndex = questionNumber;
    quizRpcService.getQuestions(quizId, new ErrorHandlingAsyncCallback<List<Question>>() {
      public void onSuccess(List<Question> result) {
        if (result.isEmpty()) {
          Question newQuestion = new QuestionImpl();
          newQuestion.setQuizId(quizId);
          List<Answer> answers = new ArrayList<Answer>();
          answers.add(new AnswerImpl());
          newQuestion.setAnswers(answers);
          result.add(newQuestion);
        }
        questions = result;
        updateView();
      }
    });
  }

  private void updateView() {
    display().setData(questions.get(currentQuestionIndex), questions.size(), currentQuestionIndex);
  }

  @Override
  protected void bind() {
    display().getButtonBack().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        goTo(new EditQuizPlace(quizId));
      }
    });
    display().getButtonSave().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        doSave();
      }
    });
    display().getButtonAdd().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        doAdd();
      }
    });
    display().getButtonDelete().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        askToDelete();
      }
    });
    display().getButtonSaveAndNext().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        doSaveAndNext();
      }
    });
  }

  private void doSave() {
    quizRpcService.saveQuestion(display().getData(), new ErrorHandlingAsyncCallback<Void>() {
      public void onSuccess(Void result) {
        display().showMessage("Changes are succefully saved!");
      }
    });
  }

  private void askToDelete() {
    if (questions.size() == 1) {
      Dialog.showMessageDialog("Cannot delete!", "Quiz should have at least one question", Dialog.Type.INFO);
      return;
    }

    String message = "Are you sure you want to delete this question?";
    Dialog.showConfirmationDialog("Delete?", message, new ConfirmationDialogEventHandler() {
      public void onConfirmation(ConfirmationDialogEvent confirmationDialogEvent) {
        if (confirmationDialogEvent.isConfirmed()) {
          doDelete();
        }
      }
    });
  }

  private void doDelete() {
    if (display().getData().isNew()) {
      afterDelete();
    } else {
      quizRpcService.deleteQuestion(display().getData(), new ErrorHandlingAsyncCallback<Void>() {
        public void onSuccess(Void result) {
          afterDelete();
        }
      });
    }
  }

  private void afterDelete() {
    questions.remove(currentQuestionIndex);
    if (currentQuestionIndex == questions.size()) {
      currentQuestionIndex--;
    }
    updateView();
  }

  private void doAdd() {
    currentQuestionIndex++;
    Question newQuestion = new QuestionImpl();
    newQuestion.setQuizId(quizId);
    List<Answer> answers = new ArrayList<Answer>();
    answers.add(new AnswerImpl());
    newQuestion.setAnswers(answers);
    questions.add(currentQuestionIndex, newQuestion);
    updateView();
  }

  private void doSaveAndNext() {
    doSave();
    if (currentQuestionIndex == questions.size() - 1) {
      doAdd();
    } else {
      currentQuestionIndex++;
      updateView();
    }
  }

  private Display display() {
    return (Display) baseDisplay;
  }
}
