package quiz.jf.model;

import jakarta.persistence.*;

@SequenceGenerator(name = "player_seq", allocationSize = 1)
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    private Long id;
    private String nickName;
    private String fullName;
    private int age;
    private String email;
    private String password;

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private QuizResult quizResult;

    public Player(){

    }

    public Player(Long id, String nickName) {
        this.id = id;
        this.nickName = nickName;
    }

    public Player(String nickName, String fullName, int age, String email, String password) {
        this.nickName = nickName;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Player(Long id, String nickName, String fullName, int age, String email, String password) {
        this.id = id;
        this.nickName = nickName;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Player(Long id, String nickName, String fullName, int age, String email, String password, QuizResult quizResult) {
        this.id = id;
        this.nickName = nickName;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.quizResult = quizResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public QuizResult getQuizResult() {
        return quizResult;
    }

    public void setQuizResult(QuizResult quizResult) {
        this.quizResult = quizResult;
    }


    public static final class Builder {
        private Player player;

        private Builder() {
            player = new Player();
        }

        public static Builder aPlayer() {
            return new Builder();
        }

        public Builder id(Long id) {
            player.setId(id);
            return this;
        }

        public Builder name(String name) {
            player.setNickName(name);
            return this;
        }

        public Builder fullName(String fullName) {
            player.setFullName(fullName);
            return this;
        }

        public Builder age(int age) {
            player.setAge(age);
            return this;
        }

        public Builder email(String email) {
            player.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            player.setPassword(password);
            return this;
        }

        public Builder quizResult(QuizResult quizResult) {
            player.setQuizResult(quizResult);
            return this;
        }

        public Player build() {
            return player;
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + nickName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", quizResult=" + quizResult +
                '}';
    }
}
