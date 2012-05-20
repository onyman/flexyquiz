package com.flexyquiz.app.shared.func.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.flexyquiz.app.shared.core.model.AbstractPersistent;

@Document(collection="question")
public class QuestionImpl extends AbstractPersistent implements Question {
  private String quizId;
  private String questionText;
  private QuestionType type;
  private List<Answer> answers;
  private String explanation;

  public String getQuizId() {
    return quizId;
  }

  public String getQuestionText() {
    return questionText;
  }

  public QuestionType getType() {
    return type;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public String getExplanation() {
    return explanation;
  }

  public void setQuizId(String quizId) {
    this.quizId = quizId;
  }

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  public void setType(QuestionType type) {
    this.type = type;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  public void setExplanation(String explanation) {
    this.explanation = explanation;
  }
}
