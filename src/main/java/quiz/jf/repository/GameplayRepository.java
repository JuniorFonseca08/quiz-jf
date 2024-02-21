package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import quiz.jf.model.Gameplay;

public interface GameplayRepository extends JpaRepository<Gameplay, Long> {

    @Modifying
    @Query(value = "UPDATE gameplay SET pontuacao_total = (SELECT COALESCE(SUM(gq.pontuacao), 0) FROM questoes_gameplay gq WHERE gq.gameplay_id = :gameplayId) WHERE id = :gameplayId", nativeQuery = true)
    void calculateTotalScoreByGameplayId(@Param("gameplayId") Long gameplayId);

}
