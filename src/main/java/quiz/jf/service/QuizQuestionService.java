package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.QuizQuestion;
import quiz.jf.repository.QuestionAlternativeRepository;
import quiz.jf.repository.QuizQuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuizQuestionService {
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;
    @Autowired
    private QuestionAlternativeRepository questionAlternativeRepository;

    public QuizQuestion saveQuestion(QuizQuestion quizQuestion){
        return quizQuestionRepository.save(quizQuestion);
    }

    public List<QuizQuestion> saveAll(List<QuizQuestion> quizQuestionList){
        List<QuizQuestion> savedQuestions = quizQuestionRepository.saveAll(quizQuestionList);

        savedQuestions.forEach(quizQuestion -> {
            quizQuestion.getAlternatives().forEach(alternative -> alternative.setQuizQuestion(quizQuestion));
            questionAlternativeRepository.saveAll(quizQuestion.getAlternatives());
        });
        return quizQuestionRepository.saveAll(quizQuestionList);
    }

    public List<QuizQuestion> findAll(){
        return quizQuestionRepository.findAll();
    }

    public QuizQuestion findById(Long id){
        return quizQuestionRepository.findById(id).get();
    }

    public List<QuizQuestion> findByTheme(String theme){
        return quizQuestionRepository.findByTheme(theme);
    }

//    public Optional<QuizQuestion> findByIdWithAlternatives(Long id){
//        return quizQuestionRepository.findByIdWithAlternatives(id);
//    }

}
