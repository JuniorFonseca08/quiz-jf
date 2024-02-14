package quiz.jf.model;

import jakarta.persistence.*;

@SequenceGenerator(name = "quiz_room_seq", allocationSize = 1)
@Entity
@Table(name = "quiz_room")
public class QuizRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_room_seq")
    private Long id;
    private String theme;
    private String nickName;

    public QuizRoom(){

    }

    public QuizRoom(Long id, String theme, String nickName) {
        this.id = id;
        this.theme = theme;
        this.nickName = nickName;
    }

    public QuizRoom(String nickName, String theme) {
        this.nickName = nickName;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public static final class Builder {
        private QuizRoom quizRoom;

        public static Builder aQuizRoom() {
            return new Builder();
        }

        public Builder id(Long id) {
            quizRoom.setId(id);
            return this;
        }

        public Builder thema(String thema) {
            quizRoom.setTheme(thema);
            return this;
        }

        public Builder nickName(String nickName) {
            quizRoom.setNickName(nickName);
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
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
