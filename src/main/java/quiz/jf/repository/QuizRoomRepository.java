package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import quiz.jf.model.Player;
import quiz.jf.model.QuizRoom;

public interface QuizRoomRepository extends JpaRepository<QuizRoom, Long> {
    QuizRoom findByNickNameAndTheme(String theme, String nickName);

    QuizRoom findByThemeAndPlayer(String theme, Player player);
}
