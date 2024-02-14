package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.jf.model.Player;
import quiz.jf.model.QuizQuestion;

import java.util.List;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {
    List<QuizQuestion> findByTheme(String theme);
}
