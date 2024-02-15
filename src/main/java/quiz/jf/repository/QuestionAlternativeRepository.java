package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import quiz.jf.model.Player;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.model.QuizQuestion;

import java.util.List;
import java.util.Optional;

public interface QuestionAlternativeRepository extends JpaRepository<QuestionAlternative, Long> {
    List<QuestionAlternative> findByQuizQuestionId(Long questionId);
}
