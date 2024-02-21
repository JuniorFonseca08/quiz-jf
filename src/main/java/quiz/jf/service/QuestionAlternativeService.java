package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.model.Question;
import quiz.jf.repository.QuestionAlternativeRepository;
import quiz.jf.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionAlternativeService {
    @Autowired
    private QuestionAlternativeRepository questionAlternativeRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<QuestionAlternative> findAll(){
        return questionAlternativeRepository.findAll();
    }

    public QuestionAlternative save(QuestionAlternative alternative){
        Optional<Question> question = questionRepository.findById(alternative.getId());
        question.ifPresent(value -> alternative.setQuizQuestion(question.get()));

        QuestionAlternative savedAlternative = questionAlternativeRepository.save(alternative);
        return savedAlternative;
    }

}