package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.jf.model.Player;
import quiz.jf.model.QuizRoom;

public interface QuizRoomRepository extends JpaRepository<QuizRoom, Long> {
    QuizRoom findByNickNameAndTheme(String nickName, String theme);
}
