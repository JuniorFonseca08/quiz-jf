package quiz.jf.builder;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import quiz.jf.dto.GameplayDTO;
import quiz.jf.dto.QuizRoomDTO;
import quiz.jf.model.Gameplay;
import quiz.jf.model.QuizRoom;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuizRoomMapper {

    private final ModelMapper modelMapper;

    public QuizRoomMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuizRoomDTO toDTO(QuizRoom model) {
        return modelMapper.map(model, QuizRoomDTO.class);
    }

    public QuizRoom toEntity(QuizRoomDTO dto) {
        return modelMapper.map(dto, QuizRoom.class);
    }


    public List<QuizRoomDTO> toListDTO(List<QuizRoom> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<QuizRoom> toList(List<QuizRoomDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }
}
