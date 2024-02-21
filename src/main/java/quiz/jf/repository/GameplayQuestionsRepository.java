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

    GameplayQuestions findFirstByWasPlayedFalse();

}
//@Param("resposta_correta") boolean wasCorrect