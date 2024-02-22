package quiz.jf.builder;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import quiz.jf.dto.GameplayDTO;
import quiz.jf.dto.GameplayQuestionsDTO;
import quiz.jf.model.Gameplay;
import quiz.jf.model.GameplayQuestions;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameplayQuestionsMapper {

    private final ModelMapper modelMapper;

    public GameplayQuestionsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GameplayQuestionsDTO toDTO(GameplayQuestions model) {
        return modelMapper.map(model, GameplayQuestionsDTO.class);
    }

    public GameplayQuestions toEntity(GameplayQuestionsDTO dto) {
        return modelMapper.map(dto, GameplayQuestions.class);
    }


    public List<GameplayQuestionsDTO> toListDTO(List<GameplayQuestions> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<GameplayQuestions> toList(List<GameplayQuestionsDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }
}
