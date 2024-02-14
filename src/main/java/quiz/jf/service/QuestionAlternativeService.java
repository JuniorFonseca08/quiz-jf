package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.model.QuizQuestion;
import quiz.jf.repository.QuestionAlternativeRepository;

import java.util.List;
@Service
public class QuestionAlternativeService {
    @Autowired
    private QuestionAlternativeRepository questionAlternativeRepository;

//    public List<QuestionAlternative> saveAlternativesWithQuestion(List<QuestionAlternative> alternativeList, QuizQuestion question){
//
//        for (QuestionAlternative alternative : alternativeList){
//            alternative.setQuizQuestion(question);
//        }
//        return questionAlternativeRepository.saveAll(alternativeList);
//    }

    public QuestionAlternative save(QuestionAlternative alternative){
        return questionAlternativeRepository.save(alternative);
    }

    public List<QuestionAlternative> findAll(){
        return questionAlternativeRepository.findAll();
    }

}