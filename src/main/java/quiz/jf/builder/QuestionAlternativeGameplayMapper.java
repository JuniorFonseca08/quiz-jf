package quiz.jf.builder;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import quiz.jf.dto.GameplayDTO;
import quiz.jf.dto.QuestionAlternativeGameplayDTO;
import quiz.jf.model.Gameplay;
import quiz.jf.model.QuestionAlternative;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionAlternativeGameplayMapper {

    private final ModelMapper modelMapper;

    public QuestionAlternativeGameplayMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuestionAlternativeGameplayDTO toDTO(QuestionAlternative model) {
        return modelMapper.map(model, QuestionAlternativeGameplayDTO.class);
    }

    public QuestionAlternative toEntity(QuestionAlternativeGameplayDTO dto) {
        return modelMapper.map(dto, QuestionAlternative.class);
    }


    public List<QuestionAlternativeGameplayDTO> toListDTO(List<QuestionAlternative> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<QuestionAlternative> toList(List<QuestionAlternativeGameplayDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }
}
