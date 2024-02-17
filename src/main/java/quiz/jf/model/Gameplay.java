package quiz.jf.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "gameplay_seq", allocationSize = 1)
@Entity
@Table(name = "gameplay")
public class Gameplay {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gameplay_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "quiz_sala_id")
    private QuizRoom quizRoom;

    @OneToMany()
    @JoinColumn(name = "questao_id")
    private List<QuizQuestion> questionList = new ArrayList<>();

    private Long score;

    private Boolean wasPlayed;

    private Boolean playerWin;

    public Gameplay() {

    }

    public Gameplay(Long id, Player player, QuizRoom quizRoom, List<QuizQuestion> questionList, Long score) {
        this.id = id;
        this.player = player;
        this.quizRoom = quizRoom;
        this.questionList = questionList;
        this.score = score;
    }

    public Gameplay(Long id, Player player, QuizRoom quizRoom, List<QuizQuestion> questionList, Long score, Boolean wasPlayed, Boolean playerWin) {
        this.id = id;
        this.player = player;
        this.quizRoom = quizRoom;
        this.questionList = questionList;
        this.score = score;
        this.wasPlayed = wasPlayed;
        this.playerWin = playerWin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public QuizRoom getQuizRoom() {
        return quizRoom;
    }

    public void setQuizRoom(QuizRoom quizRoom) {
        this.quizRoom = quizRoom;
    }

    public List<QuizQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuizQuestion> questionList) {
        this.questionList = questionList;
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

    public Boolean getPlayerWin() {
        return playerWin;
    }

    public void setPlayerWin(Boolean playerWin) {
        this.playerWin = playerWin;
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

        public Builder player(Player player) {
            gameplay.setPlayer(player);
            return this;
        }

        public Builder quizRoom(QuizRoom quizRoom) {
            gameplay.setQuizRoom(quizRoom);
            return this;
        }

        public Builder questionList(List<QuizQuestion> questionList) {
            gameplay.setQuestionList(questionList);
            return this;
        }

        public Builder score(Long score) {
            gameplay.setScore(score);
            return this;
        }

        public Builder wasPlayed(Boolean wasPlayed) {
            gameplay.setWasPlayed(wasPlayed);
            return this;
        }

        public Builder playerWin(Boolean playerWin) {
            gameplay.setPlayerWin(playerWin);
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
                ", player=" + player +
                ", quizRoom=" + quizRoom +
                ", questionList=" + questionList +
                ", score=" + score +
                ", wasPlayed=" + wasPlayed +
                ", playerWin=" + playerWin +
                '}';
    }
}
