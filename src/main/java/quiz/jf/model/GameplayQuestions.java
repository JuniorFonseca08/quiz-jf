package quiz.jf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
@SequenceGenerator(name = "questoes_gameplay_seq", allocationSize = 1)
@Entity
@Table(name = "questoes_gameplay")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameplayQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questoes_gameplay_seq")
    private Long id;

    @Column(name = "pontuacao")
    private Long score = 0L;
    @Column(name = "foi_jogado")
    private Boolean wasPlayed = false;
    @Column(name = "resposta_correta")
    private Boolean correctAnswer = false;
    @ManyToOne
    @JoinColumn(name = "gameplay_id")
    @JsonIgnore
    private Gameplay gameplay;
    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;

    public GameplayQuestions(){

    }

    public GameplayQuestions(Long id, Long score, Boolean wasPlayed, Boolean correctAnswer, Gameplay gameplay, Question question) {
        this.id = id;
        this.score = score;
        this.wasPlayed = wasPlayed;
        this.correctAnswer = correctAnswer;
        this.gameplay = gameplay;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Boolean getWasPlayed() {
        return wasPlayed;
    }

    public void setWasPlayed(Boolean wasPlayed) {
        this.wasPlayed = wasPlayed;
    }

    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Gameplay getGameplay() {
        return gameplay;
    }

    public void setGameplay(Gameplay gameplay) {
        this.gameplay = gameplay;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    public static final class Builder {
        private GameplayQuestions gameplayQuestions;

        private Builder() {
            gameplayQuestions = new GameplayQuestions();
        }

        public static Builder aGameplayQuestions() {
            return new Builder();
        }

        public Builder id(Long id) {
            gameplayQuestions.setId(id);
            return this;
        }

        public Builder score(Long score) {
            gameplayQuestions.setScore(score);
            return this;
        }

        public Builder wasPlayed(Boolean wasPlayed) {
            gameplayQuestions.setWasPlayed(wasPlayed);
            return this;
        }

        public Builder correctAnswer(Boolean correctAnswer) {
            gameplayQuestions.setCorrectAnswer(correctAnswer);
            return this;
        }

        public Builder gameplay(Gameplay gameplay) {
            gameplayQuestions.setGameplay(gameplay);
            return this;
        }

        public Builder question(Question question) {
            gameplayQuestions.setQuestion(question);
            return this;
        }

        public GameplayQuestions build() {
            return gameplayQuestions;
        }
    }

    @Override
    public String toString() {
        return "GameplayQuestionsService{" +
                "id=" + id +
                ", score=" + score +
                ", wasPlayed=" + wasPlayed +
                ", correctAnswer=" + correctAnswer +
                ", question=" + question +
                '}';
    }
}
