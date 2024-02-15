package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import quiz.jf.model.QuizQuestion;

import java.util.List;
import java.util.Optional;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {
    List<QuizQuestion> findByTheme(String theme);
    @Query("SELECT q FROM QuizQuestion q LEFT JOIN FETCH q.alternatives WHERE q.id = :id")
    Optional<QuizQuestion> findByIdWithAlternatives(@Param("id") Long id);
}

