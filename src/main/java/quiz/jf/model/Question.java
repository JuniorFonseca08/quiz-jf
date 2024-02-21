package quiz.jf.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@SequenceGenerator(name = "questao_seq", allocationSize = 1)
@Entity
@Table(name = "questao")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questao_seq")
    private Long id;
    @Column(name = "questao")
    private String query;
    @Column(name = "tema")
    private String theme;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<QuestionAlternative> alternatives = new ArrayList<>();


    public Question(){

    }

    public Question(Long id, String query, String theme, List<QuestionAlternative> alternatives) {
        this.id = id;
        this.query = query;
        this.theme = theme;
        this.alternatives = alternatives;
    }

    public Question(String query, String theme, List<QuestionAlternative> alternatives) {
        this.query = query;
        this.theme = theme;
        this.alternatives = alternatives;
    }

    public Question(String query, List<QuestionAlternative> alternatives) {
        this.query = query;
        this.alternatives = alternatives;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<QuestionAlternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<QuestionAlternative> alternatives) {
        this.alternatives = alternatives;
    }

    public static final class Builder {
        private Question question;

        private Builder() {
            question = new Question();
        }

        public static Builder aQuestion() {
            return new Builder();
        }

        public Builder id(Long id) {
            question.setId(id);
            return this;
        }

        public Builder query(String query) {
            question.setQuery(query);
            return this;
        }

        public Builder theme(String theme) {
            question.setTheme(theme);
            return this;
        }

        public Builder alternatives(List<QuestionAlternative> alternatives) {
            question.setAlternatives(alternatives);
            return this;
        }

        public Question build() {
            return question;
        }
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", query='" + query + '\'' +
                ", theme='" + theme + '\'' +
                ", alternatives=" + alternatives +
                '}';
    }
}
