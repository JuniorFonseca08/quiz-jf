package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import quiz.jf.model.QuestionAlternative;

import java.util.List;

public interface QuestionAlternativeRepository extends JpaRepository<QuestionAlternative, Long> {
    List<QuestionAlternative> findByQuestionId(Long questionId);

    @Query("SELECT qa.id FROM QuestionAlternative qa WHERE qa.isCorrect = true")
    Long findCorrectAlternativeId();
}
