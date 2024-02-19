package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import quiz.jf.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByTheme(String theme);
    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.alternatives WHERE q.id = :id")
    Optional<Question> findByIdWithAlternatives(@Param("id") Long id);
}

