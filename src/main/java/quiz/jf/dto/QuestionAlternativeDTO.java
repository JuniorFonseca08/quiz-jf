package quiz.jf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import quiz.jf.model.Question;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAlternativeDTO {

    private Long id;

    private String alternative;

    private boolean isCorrect;

    private Question question;

    @Override
    public String toString() {
        return "QuestionAlternativeDTO{" +
                "id=" + id +
                ", alternative='" + alternative + '\'' +
                ", isCorrect=" + isCorrect +
                ", question=" + question +
                '}';
    }
}
