package com.flexyquiz.app.client.func.manage.quiz;

import java.util.List;

import com.flexyquiz.app.shared.func.model.Question;
import com.flexyquiz.app.shared.func.model.Quiz;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("quizsvc")
public interface QuizRpcService extends RemoteService {
  List<? extends Quiz> getQuizList();

  Quiz getById(String id);
 
  void save(Quiz quiz);
  
  void delete(Quiz quiz);
  
  
  List<Question> getQuestions(String quizId);
  
  void saveQuestion(Question question);
  
  void deleteQuestion(Question question);
}
