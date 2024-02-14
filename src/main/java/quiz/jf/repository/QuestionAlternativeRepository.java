package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.jf.model.Player;
import quiz.jf.model.QuestionAlternative;

import java.util.List;

public interface QuestionAlternativeRepository extends JpaRepository<QuestionAlternative, Long> {
    List<QuestionAlternative> findByQuizQuestionId(Long questionId);
}
