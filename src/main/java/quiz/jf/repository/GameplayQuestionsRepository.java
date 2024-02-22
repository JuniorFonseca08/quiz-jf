package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import quiz.jf.model.Gameplay;
import quiz.jf.model.GameplayQuestions;
import quiz.jf.model.Question;

import java.util.List;

public interface GameplayQuestionsRepository extends JpaRepository<GameplayQuestions, Long> {
    @Query("SELECT gq.question FROM GameplayQuestions gq WHERE gq.gameplay = :gameplay")
    List<Question> findAllQuestionsByGameplay(Gameplay gameplay);

    @Query("SELECT gq FROM GameplayQuestions gq " +
            "WHERE gq.gameplay = :gameplay AND gq.wasPlayed = false")
    List<GameplayQuestions> findNextUnansweredQuestionByGameplay(@Param("gameplay") Gameplay gameplay);

}
