package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.builder.QuestionMapper;
import quiz.jf.dto.QuestionDTO;
import quiz.jf.model.Question;
import quiz.jf.repository.QuestionAlternativeRepository;
import quiz.jf.repository.QuestionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionAlternativeRepository questionAlternativeRepository;
    @Autowired
    private QuestionMapper questionMapper;

    public QuestionDTO saveQuestion(QuestionDTO questionDTO){
        return questionMapper.toDTO(questionRepository.save(questionMapper.toEntity(questionDTO)));
    }

    public List<QuestionDTO> saveAll(List<QuestionDTO> questionDTOList){
        List<Question> questions = questionDTOList.stream()
                .map(questionMapper::toEntity)
                .collect(Collectors.toList());
        List<Question> savedQuestions = questionRepository.saveAll(questions);

        savedQuestions.forEach(quizQuestion -> {
            quizQuestion.getAlternatives().forEach(alternative -> alternative.setQuestion(quizQuestion));
            questionAlternativeRepository.saveAll(quizQuestion.getAlternatives());
        });

        return savedQuestions.stream()
                .map(questionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<QuestionDTO> findAll(){
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(questionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public QuestionDTO findById(Long id){
        return questionMapper.toDTO(questionRepository.findById(id).get());
    }

    public List<QuestionDTO> findByTheme(String theme){
        return questionRepository.findByTheme(theme).stream()
                .map(questionMapper::toDTO)
                .collect(Collectors.toList());
    }

}
