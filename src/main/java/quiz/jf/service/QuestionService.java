package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.Question;
import quiz.jf.repository.QuestionAlternativeRepository;
import quiz.jf.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionAlternativeRepository questionAlternativeRepository;

    public Question saveQuestion(Question question){
        return questionRepository.save(question);
    }

    public List<Question> saveAll(List<Question> questionList){
        List<Question> savedQuestions = questionRepository.saveAll(questionList);

        savedQuestions.forEach(quizQuestion -> {
            quizQuestion.getAlternatives().forEach(alternative -> alternative.setQuizQuestion(quizQuestion));
            questionAlternativeRepository.saveAll(quizQuestion.getAlternatives());
        });
        return questionRepository.saveAll(questionList);
    }

    public List<Question> findAll(){
        return questionRepository.findAll();
    }

    public Question findById(Long id){
        return questionRepository.findById(id).get();
    }

    public List<Question> findByTheme(String theme){
        return questionRepository.findByTheme(theme);
    }

}
