package quiz.jf.builder;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import quiz.jf.dto.GameplayDTO;
import quiz.jf.dto.QuestionAlternativeDTO;
import quiz.jf.model.Gameplay;
import quiz.jf.model.QuestionAlternative;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionAlternativeMapper {

    private final ModelMapper modelMapper;

    public QuestionAlternativeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuestionAlternativeDTO toDTO(QuestionAlternative model) {
        return modelMapper.map(model, QuestionAlternativeDTO.class);
    }

    public QuestionAlternative toEntity(QuestionAlternativeDTO dto) {
        return modelMapper.map(dto, QuestionAlternative.class);
    }


    public List<QuestionAlternativeDTO> toListDTO(List<QuestionAlternative> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<QuestionAlternative> toList(List<QuestionAlternativeDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }
}
