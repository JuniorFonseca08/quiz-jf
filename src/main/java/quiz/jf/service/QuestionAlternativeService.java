package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.model.QuizQuestion;
import quiz.jf.repository.QuestionAlternativeRepository;
import quiz.jf.repository.QuizQuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionAlternativeService {
    @Autowired
    private QuestionAlternativeRepository questionAlternativeRepository;

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

//    public List<QuestionAlternative> saveAlternativesWithQuestion(List<QuestionAlternative> alternativeList, QuizQuestion question){
//
//        for (QuestionAlternative alternative : alternativeList){
//            alternative.setQuizQuestion(question);
//        }
//        return questionAlternativeRepository.saveAll(alternativeList);
//    }

//    public QuestionAlternative save(QuestionAlternative alternative){
//        return questionAlternativeRepository.save(alternative);
//    }

    public List<QuestionAlternative> findAll(){
        return questionAlternativeRepository.findAll();
    }

    public QuestionAlternative save(QuestionAlternative alternative){
        Optional<QuizQuestion> question = quizQuestionRepository.findById(alternative.getId());
        question.ifPresent(value -> alternative.setQuizQuestion(question.get()));

        QuestionAlternative savedAlternative = questionAlternativeRepository.save(alternative);
        return savedAlternative;
    }

}