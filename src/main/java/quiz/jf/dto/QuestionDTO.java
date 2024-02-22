package quiz.jf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import quiz.jf.model.Question;
import quiz.jf.model.QuestionAlternative;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private Long id;

    private String query;

    private String theme;

    private List<QuestionAlternative> alternatives = new ArrayList<>();

    public QuestionDTO(Question question) {

    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id=" + id +
                ", query='" + query + '\'' +
                ", theme='" + theme + '\'' +
                ", alternatives=" + alternatives +
                '}';
    }
}
