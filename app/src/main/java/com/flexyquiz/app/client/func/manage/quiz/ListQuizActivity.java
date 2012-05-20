package com.flexyquiz.app.client.func.manage.quiz;

import java.util.List;

import com.flexyquiz.app.client.core.mvp.BaseActivity;
import com.flexyquiz.app.client.core.mvp.BaseDisplay;
import com.flexyquiz.app.client.core.rpc.ErrorHandlingAsyncCallback;
import com.flexyquiz.app.shared.func.model.Quiz;
import com.google.gwt.view.client.CellPreviewEvent;
import com.google.gwt.view.client.CellPreviewEvent.Handler;
import com.google.gwt.view.client.HasCellPreviewHandlers;

public class ListQuizActivity extends BaseActivity {
  public interface Display extends BaseDisplay {
    void setListData(List<? extends Quiz> newData);
    HasCellPreviewHandlers<Quiz> getGrid();
  }

  @Override
  protected void onStart() {
    QuizRpcServiceAsync.Util.getInstance().getQuizList(new ErrorHandlingAsyncCallback<List<? extends Quiz>>() {
      public void onSuccess(List<? extends Quiz> result) {
        display().setListData(result);
      }
    });
  }

  @Override
  protected void bind() {
    display().getGrid().addCellPreviewHandler(new Handler<Quiz>() {
      public void onCellPreview(CellPreviewEvent<Quiz> event) {
        boolean isClick = "click".equals(event.getNativeEvent().getType());
        if (isClick) {
          Quiz quiz = event.getValue();
          goTo(new EditQuizPlace(quiz.getId()));
        }
      }
    });
  }

  private Display display() {
    return (Display) baseDisplay;
  }
}
