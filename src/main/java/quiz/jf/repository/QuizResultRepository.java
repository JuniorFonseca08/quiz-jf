package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.jf.model.Player;

public interface QuizResultRepository extends JpaRepository<Player, Long> {
}
