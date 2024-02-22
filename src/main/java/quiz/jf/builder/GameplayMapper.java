package quiz.jf.builder;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import quiz.jf.dto.GameplayDTO;
import quiz.jf.model.Gameplay;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameplayMapper {

    private final ModelMapper modelMapper;

    public GameplayMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GameplayDTO toDTO(Gameplay model) {
        return modelMapper.map(model, GameplayDTO.class);
    }

    public Gameplay toEntity(GameplayDTO dto) {
        return modelMapper.map(dto, Gameplay.class);
    }


    public List<GameplayDTO> toListDTO(List<Gameplay> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<Gameplay> toList(List<GameplayDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }
}
