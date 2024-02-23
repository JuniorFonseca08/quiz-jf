package quiz.jf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import quiz.jf.model.Gameplay;
import quiz.jf.model.Question;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameplayQuestionsDTO {

    private Long id;

    private Long score = 0L;

    private Boolean wasPlayed = false;

    private Boolean correctAnswer = false;

    private Gameplay gameplay;

    private Question question;

    @Override
    public String toString() {
        return "GameplayQuestionsDTO{" +
                "id=" + id +
                ", score=" + score +
                ", wasPlayed=" + wasPlayed +
                ", correctAnswer=" + correctAnswer +
                ", gameplay=" + gameplay +
                ", question=" + question +
                '}';
    }
}
