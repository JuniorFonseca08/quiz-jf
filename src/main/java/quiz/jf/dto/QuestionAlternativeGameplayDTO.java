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
public class QuestionAlternativeGameplayDTO {

    private Long id;

    private String alternative;

    private Question question;

    @Override
    public String toString() {
        return "QuestionAlternativeDTO{" +
                "id=" + id +
                ", alternative='" + alternative + '\'' +
                ", question=" + question +
                '}';
    }
}
