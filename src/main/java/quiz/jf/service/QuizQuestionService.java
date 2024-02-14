package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.QuizQuestion;
import quiz.jf.repository.QuizQuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuizQuestionService {
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    public QuizQuestion saveQuestion(QuizQuestion quizQuestion){
        return quizQuestionRepository.save(quizQuestion);
    }

    public List<QuizQuestion> findAll(){
        return quizQuestionRepository.findAll();
    }

    public Optional<QuizQuestion> findById(Long id){
        return quizQuestionRepository.findById(id);
    }

    public List<QuizQuestion> findByTheme(String theme){
        return quizQuestionRepository.findByTheme(theme);
    }



}
