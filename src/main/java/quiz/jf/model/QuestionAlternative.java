package quiz.jf.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.persistence.*;
@SequenceGenerator(name = "alternativa_seq", allocationSize = 1)
@Entity
@Table(name = "alternativa")
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionAlternative {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alternativa_seq")
    private Long id;
    @Column(name = "alternativa")
    private String alternative;

    @Column(name = "eh_correta")
    private boolean isCorrect;
    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Question question;

    public QuestionAlternative(){

    }

    public QuestionAlternative(Long id, String alternative, boolean isCorrect) {
        this.id = id;
        this.alternative = alternative;
        this.isCorrect = isCorrect;
    }

    public QuestionAlternative(String alternative, boolean isCorrect) {
        this.alternative = alternative;
        this.isCorrect = isCorrect;
    }

    public QuestionAlternative(String alternative, boolean isCorrect, Question question) {
        this.alternative = alternative;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public QuestionAlternative(Long id, String alternative) {
        this.id = id;
        this.alternative = alternative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    @JsonIgnore
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuizQuestion() {
        return question;
    }

    public void setQuizQuestion(Question question) {
        this.question = question;
    }


    public static final class Builder {
        private QuestionAlternative questionAlternative;

        private Builder() {
            questionAlternative = new QuestionAlternative();
        }

        public static Builder aQuestionAlternative() {
            return new Builder();
        }

        public Builder id(Long id) {
            questionAlternative.setId(id);
            return this;
        }

        public Builder alternative(String alternative) {
            questionAlternative.setAlternative(alternative);
            return this;
        }

        public Builder quizQuestion(Question question) {
            questionAlternative.setQuizQuestion(question);
            return this;
        }

        public QuestionAlternative build() {
            return questionAlternative;
        }
    }

    @Override
    public String toString() {
        return "QuestionAlternativeService{" +
                "id=" + id +
                ", alternative='" + alternative + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }

}
