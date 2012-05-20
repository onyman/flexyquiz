package com.flexyquiz.app.client.func.manage.quiz;

import com.flexyquiz.app.client.core.mvp.BaseView;
import com.flexyquiz.app.client.core.mvp.View;
import com.flexyquiz.app.shared.func.model.Quiz;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

@View(forActivity=EditQuizActivity.class)
public class EditQuizView extends BaseView implements EditQuizActivity.Display {
  interface EditQuizViewUiBinder extends UiBinder<Widget, EditQuizView> {
  }
  
  private static EditQuizViewUiBinder uiBinder = GWT.create(EditQuizViewUiBinder.class);

  private Quiz quiz;
  
  @UiField
  TextBox nameTextBox;
  
  @UiField
  TextBox descriptionTextBox;

  @UiField
  Button cancelButton;
  
  @UiField
  Button saveButton;
  
  @UiField 
  Button deleteButton;
  
  @UiField
  Button editQuestionsButton;
  
  public EditQuizView() {
    initWidget(uiBinder.createAndBindUi(this));
  }
  
  public void setData(Quiz quiz) {
    this.quiz = quiz;
    nameTextBox.setText(quiz.getName());
    descriptionTextBox.setText(quiz.getDescription());
    
    if (quiz.isNew()) {
      deleteButton.setVisible(false);
    }
  }
  
  public Quiz getData() {
    quiz.setName(nameTextBox.getText());
    quiz.setDescription(descriptionTextBox.getText());
    return quiz;
  }

  public HasClickHandlers getCancelButton() {
    return cancelButton;
  }

  public HasClickHandlers getSaveButton() {
    return saveButton;
  }

  public HasClickHandlers getDeleteButton() {
    return deleteButton;
  }

  public HasClickHandlers getEditQuestionsButton() {
    return editQuestionsButton;
  }
}
