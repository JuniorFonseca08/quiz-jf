package quiz.jf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlternativeDTO {

    private Long id;

    private String alternative;

    @Override
    public String toString() {
        return "AlternativeDTO{" +
                "id=" + id +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}
