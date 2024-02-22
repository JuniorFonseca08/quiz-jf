package quiz.jf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleQuestionDTO {

    private Long id;

    private String query;

    private String theme;

    private List<AlternativeDTO> alternatives;

    @Override
    public String toString() {
        return "SimpleQuestionDTO{" +
                "id=" + id +
                ", query='" + query + '\'' +
                ", theme='" + theme + '\'' +
                ", alternatives=" + alternatives +
                '}';
    }
}

