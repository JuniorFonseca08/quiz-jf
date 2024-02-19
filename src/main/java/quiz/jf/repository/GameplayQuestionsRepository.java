package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.jf.model.Gameplay;
import quiz.jf.model.GameplayQuestions;

public interface GameplayQuestionsRepository extends JpaRepository<GameplayQuestions, Long> {
}
