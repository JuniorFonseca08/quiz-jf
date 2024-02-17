package quiz.jf.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@SequenceGenerator(name = "questao_seq", allocationSize = 1)
@Entity
@Table(name = "questao")
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questao_seq")
    private Long id;
    private String question;
    private String theme;
    @OneToMany(mappedBy = "quizQuestion", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<QuestionAlternative> alternatives = new ArrayList<>();


    public QuizQuestion(){

    }

    public QuizQuestion(Long id, String question, String theme, List<QuestionAlternative> alternatives) {
        this.id = id;
        this.question = question;
        this.theme = theme;
        this.alternatives = alternatives;
    }

    public QuizQuestion(String question, String theme, List<QuestionAlternative> alternatives) {
        this.question = question;
        this.theme = theme;
        this.alternatives = alternatives;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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
        private QuizQuestion quizQuestion;

        private Builder() {
            quizQuestion = new QuizQuestion();
        }

        public static Builder aQuizQuestion() {
            return new Builder();
        }

        public Builder id(Long id) {
            quizQuestion.setId(id);
            return this;
        }

        public Builder question(String question) {
            quizQuestion.setQuestion(question);
            return this;
        }

        public Builder theme(String theme) {
            quizQuestion.setTheme(theme);
            return this;
        }

        public Builder alternatives(List<QuestionAlternative> alternatives) {
            quizQuestion.setAlternatives(alternatives);
            return this;
        }

        public QuizQuestion build() {
            return quizQuestion;
        }
    }

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", theme='" + theme + '\'' +
                ", alternatives=" + alternatives +
                '}';
    }
}
