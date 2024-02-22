package quiz.jf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import quiz.jf.model.GameplayQuestions;
import quiz.jf.model.QuizRoom;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameplayDTO {

    private Long id;

    private String player;

    private QuizRoom quizRoom;

    private Long totalScore = 0L;

    private List<GameplayQuestions> questionGameplays = new ArrayList<>();

    @Override
    public String toString() {
        return "GameplayDTO{" +
                "id=" + id +
                ", player='" + player + '\'' +
                ", quizRoom=" + quizRoom +
                ", totalScore=" + totalScore +
                ", questionGameplays=" + questionGameplays +
                '}';
    }
}
