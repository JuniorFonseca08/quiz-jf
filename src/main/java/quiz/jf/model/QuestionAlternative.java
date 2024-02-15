package quiz.jf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@SequenceGenerator(name = "alternativa_seq", allocationSize = 1)
@Entity
@Table(name = "alternativa")
public class QuestionAlternative {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alternativa_seq")
    private Long id;
    private String alternative;
    private boolean isCorrect;
    @ManyToOne
    @JoinColumn(name = "questao_id")
    @JsonBackReference
    private QuizQuestion quizQuestion;

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

    public QuestionAlternative(String alternative, boolean isCorrect, QuizQuestion quizQuestion) {
        this.alternative = alternative;
        this.isCorrect = isCorrect;
        this.quizQuestion = quizQuestion;
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

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public QuizQuestion getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(QuizQuestion quizQuestion) {
        this.quizQuestion = quizQuestion;
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

        public Builder quizQuestion(QuizQuestion quizQuestion) {
            questionAlternative.setQuizQuestion(quizQuestion);
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
