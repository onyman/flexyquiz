package com.flexyquiz.app.server.func.manage.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.flexyquiz.app.client.func.manage.quiz.QuizRpcService;
import com.flexyquiz.app.server.core.rpc.GwtRpcController;
import com.flexyquiz.app.shared.func.model.Question;
import com.flexyquiz.app.shared.func.model.Quiz;
import com.flexyquiz.app.shared.func.model.QuizImpl;

@Controller("/quizsvc")
public class QuizRpcServiceImpl extends GwtRpcController implements QuizRpcService {

  @Autowired
  private QuizRepository quizRepo;
  
  @Autowired
  private QuestionRepository questionRepo;

  public List<? extends Quiz> getQuizList() {
    return quizRepo.findAll();
  }

  public Quiz getById(String id) {
    return quizRepo.findOne(id);
  }

  public void save(Quiz quiz) {
    quizRepo.save((QuizImpl) quiz);
    
    /*Answer a = new AnswerImpl();
    a.setAnswerText("That is a correct answer");
    a.setCorrect(true);
    List<Answer> answers = new ArrayList<Answer>();
    answers.add(a);
    
    QuestionImpl q = new QuestionImpl();
    q.setQuizId(quiz.getId());
    q.setQuestionText("What is the correct answer?");
    q.setType(QuestionType.MULTIPLE_CORRECT_ANSWERS);
    q.setAnswers(answers);
    q.setExplanation("Because it says so!");
    
    questionRepo.save(q);*/
  }

  public void delete(Quiz quiz) {
    quizRepo.delete((QuizImpl) quiz);
  }

  public List<? extends Question> getQuestions(String quizId) {
    return questionRepo.findByQuizId(quizId);
  }
}
