package quiz.jf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import quiz.jf.model.Gameplay;
import quiz.jf.model.Player;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizRoomDTO {

    private Long id;
    private String theme;

    private Player player;

    private List<Gameplay> gameplay = new ArrayList<>();

    @Override
    public String toString() {
        return "QuizRoomDTO{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", player=" + player +
                ", gameplay=" + gameplay +
                '}';
    }
}
