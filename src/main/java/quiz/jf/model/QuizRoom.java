package quiz.jf.model;

import jakarta.persistence.*;

@SequenceGenerator(name = "quiz_sala_seq", allocationSize = 1)
@Entity
@Table(name = "quiz_sala")
public class QuizRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_sala_seq")
    private Long id;
    private String theme;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public QuizRoom(){

    }

    public QuizRoom(Long id, String theme, Player player) {
        this.id = id;
        this.theme = theme;
        this.player = player;
    }

    public QuizRoom(String theme, Player player) {
        this.theme = theme;
        this.player = player;
    }

    public QuizRoom(String theme) {
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public static final class Builder {
        private QuizRoom quizRoom;

        private Builder() {
            quizRoom = new QuizRoom();
        }

        public static Builder aQuizRoom() {
            return new Builder();
        }

        public Builder id(Long id) {
            quizRoom.setId(id);
            return this;
        }

        public Builder theme(String theme) {
            quizRoom.setTheme(theme);
            return this;
        }

        public Builder player(Player player) {
            quizRoom.setPlayer(player);
            return this;
        }

        public QuizRoom build() {
            return quizRoom;
        }
    }

    @Override
    public String toString() {
        return "QuizRoom{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", player=" + player +
                '}';
    }
}
