package com.flexyquiz.app.client.func.manage.quiz;

import java.util.Arrays;

import com.flexyquiz.app.client.core.mvp.BaseView;
import com.flexyquiz.app.client.core.mvp.View;
import com.flexyquiz.app.client.core.widget.EnumRenderer;
import com.flexyquiz.app.client.func.common.PagesWidget;
import com.flexyquiz.app.shared.core.model.HasDisplayName;
import com.flexyquiz.app.shared.func.model.Question;
import com.flexyquiz.app.shared.func.model.QuestionType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;

@View(forActivity = EditQuestionsActivity.class)
public class EditQuestionsView extends BaseView implements EditQuestionsActivity.Display {
  interface EditQuestionsViewUiBinder extends UiBinder<Widget, EditQuestionsView> {
  }

  private EditQuestionsViewUiBinder uiBinder = GWT.create(EditQuestionsViewUiBinder.class);

  private Question question;

  /*
   * @UiField HeaderWidget header;
   */

  @UiField
  PagesWidget pagesWidget;

  @UiField
  TextArea questionTextArea;

  @UiField(provided = true)
  ValueListBox typeListBox;

  @UiField
  TextArea explanationTextArea;

  @UiField
  Button buttonBack;

  @UiField
  Button buttonSave;

  @UiField
  Button buttonSaveAndNext;

  @UiField
  Button buttonAdd;

  @UiField
  Button buttonDelete;

  public EditQuestionsView() {
    typeListBox = new ValueListBox<QuestionType>(new EnumRenderer<QuestionType>());
    typeListBox.setAcceptableValues(Arrays.asList(QuestionType.values()));

    initWidget(uiBinder.createAndBindUi(this));
  }

  public void setData(Question question, int totalQuestions) {
    this.question = question;
    // header.setTitle("Edit quiz questions: " + quiz.getName());
    pagesWidget.update(totalQuestions);
    questionTextArea.setText(question.getQuestionText());
    typeListBox.setValue(question.getType());
    explanationTextArea.setText(question.getExplanation());
  }

  public Question getData() {
    question.setQuestionText(questionTextArea.getText());
    question.setType((QuestionType) typeListBox.getValue());
    question.setExplanation(explanationTextArea.getText());

    return question;
  }

  public HasClickHandlers getButtonBack() {
    return buttonBack;
  }

  public HasClickHandlers getButtonSave() {
    return buttonSave;
  }

  public HasClickHandlers getButtonSaveAndNext() {
    return buttonSaveAndNext;
  }

  public HasClickHandlers getButtonAdd() {
    return buttonAdd;
  }

  public HasClickHandlers getButtonDelete() {
    return buttonDelete;
  }
}
