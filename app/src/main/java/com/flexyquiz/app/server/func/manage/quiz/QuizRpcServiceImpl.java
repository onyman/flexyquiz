package com.flexyquiz.app.server.func.manage.quiz;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.flexyquiz.app.client.func.manage.quiz.QuizRpcService;
import com.flexyquiz.app.server.core.rpc.GwtRpcController;
import com.flexyquiz.app.shared.func.model.Question;
import com.flexyquiz.app.shared.func.model.QuestionImpl;
import com.flexyquiz.app.shared.func.model.Quiz;
import com.flexyquiz.app.shared.func.model.QuizImpl;

@Controller("/quizsvc")
public class QuizRpcServiceImpl extends GwtRpcController implements QuizRpcService {

  @Autowired
  private QuizRepository quizRepo;

  @Autowired
  private QuestionRepository questionRepo;

  public List<? extends Quiz> getQuizList() {
    List<? extends Quiz> quizList = quizRepo.findAll();
    Collections.sort(quizList);
    return quizList;
  }

  public Quiz getById(String id) {
    return quizRepo.findOne(id);
  }

  public void save(Quiz quiz) {
    quizRepo.save((QuizImpl) quiz);
  }

  public void delete(Quiz quiz) {
    quizRepo.delete((QuizImpl) quiz);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public List<Question> getQuestions(String quizId) {
    List result = questionRepo.findByQuizId(quizId);
    return (List<Question>) result;
  }

  public void saveQuestion(Question question) {
    questionRepo.save((QuestionImpl) question);
  }

  public void deleteQuestion(Question question) {
    questionRepo.delete((QuestionImpl) question);
  }
}
