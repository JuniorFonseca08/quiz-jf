package quiz.jf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private Long id;

    private String nickName;

    private String fullName;

    private int age;
    private String email;

    private String password;

    private Long playerScore = 0L;

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", playerScore=" + playerScore +
                '}';
    }
}
