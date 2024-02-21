package quiz.jf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "gameplay_seq", allocationSize = 1)
@Entity
@Table(name = "gameplay")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Gameplay {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gameplay_seq")
    private Long id;

    @Column(name = "jogador")
    private String player;

    @ManyToOne
    @JoinColumn(name = "quiz_sala_id")
    @JsonIgnore
    private QuizRoom quizRoom;

    @Column(name = "pontuacao_total")
    private Long totalScore = 0L;

    @OneToMany(mappedBy = "gameplay", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<GameplayQuestions> questionGameplays = new ArrayList<>();


    public Gameplay() {

    }

    public Gameplay(Long id, String player, QuizRoom quizRoom, List<GameplayQuestions> questionGameplays) {
        this.id = id;
        this.player = player;
        this.quizRoom = quizRoom;
        this.questionGameplays = questionGameplays;
    }

    public Gameplay(Long id, String player, QuizRoom quizRoom, Long totalScore, List<GameplayQuestions> questionGameplays) {
        this.id = id;
        this.player = player;
        this.quizRoom = quizRoom;
        this.totalScore = totalScore;
        this.questionGameplays = questionGameplays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public QuizRoom getQuizRoom() {
        return quizRoom;
    }

    public void setQuizRoom(QuizRoom quizRoom) {
        this.quizRoom = quizRoom;
    }

    public List<GameplayQuestions> getQuestionGameplays() {
        return questionGameplays;
    }

    public void setQuestionGameplays(List<GameplayQuestions> questionGameplays) {
        this.questionGameplays = questionGameplays;
    }

    public Long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Long totalScore) {
        this.totalScore = totalScore;
    }


    public static final class Builder {
        private Gameplay gameplay;

        private Builder() {
            gameplay = new Gameplay();
        }

        public static Builder aGameplay() {
            return new Builder();
        }

        public Builder id(Long id) {
            gameplay.setId(id);
            return this;
        }

        public Builder player(String player) {
            gameplay.setPlayer(player);
            return this;
        }

        public Builder quizRoom(QuizRoom quizRoom) {
            gameplay.setQuizRoom(quizRoom);
            return this;
        }

        public Builder totalScore(Long totalScore) {
            gameplay.setTotalScore(totalScore);
            return this;
        }

        public Builder questionGameplays(List<GameplayQuestions> questionGameplays) {
            gameplay.setQuestionGameplays(questionGameplays);
            return this;
        }

        public Gameplay build() {
            return gameplay;
        }
    }

    @Override
    public String toString() {
        return "Gameplay{" +
                "id=" + id +
                ", player='" + player + '\'' +
                ", quizRoom=" + quizRoom +
                ", totalScore=" + totalScore +
                '}';
    }
}
