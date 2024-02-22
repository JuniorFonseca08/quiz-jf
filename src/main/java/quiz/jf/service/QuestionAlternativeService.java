package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.builder.QuestionAlternativeMapper;
import quiz.jf.dto.QuestionAlternativeDTO;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.model.Question;
import quiz.jf.repository.QuestionAlternativeRepository;
import quiz.jf.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionAlternativeService {
    @Autowired
    private QuestionAlternativeRepository questionAlternativeRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionAlternativeMapper questionAlternativeMapper;

    public List<QuestionAlternativeDTO> findAll(){
        List<QuestionAlternative> questionAlternativeDTOList = questionAlternativeRepository.findAll();
        return questionAlternativeDTOList.stream()
                .map(questionAlternativeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public QuestionAlternativeDTO save(QuestionAlternativeDTO alternativeDTO) {
        Optional<Question> optionalQuestion = questionRepository.findById(alternativeDTO.getId());

        if (optionalQuestion.isPresent()) {
            QuestionAlternative alternative = questionAlternativeMapper.toEntity(alternativeDTO);
            alternative.setQuestion(optionalQuestion.get());

            return questionAlternativeMapper.toDTO(questionAlternativeRepository.save(alternative));
        } else {
            throw new IllegalArgumentException("Pergunta não encontrada com o ID fornecido: " + alternativeDTO.getId());
        }
    }

}