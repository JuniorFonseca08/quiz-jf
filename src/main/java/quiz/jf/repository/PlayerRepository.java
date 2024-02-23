package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import quiz.jf.model.Player;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByEmail(String email);

    Player findByNickName(String nickName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Player p SET p.playerScore = COALESCE((SELECT SUM(g.totalScore) FROM Gameplay g WHERE g.quizRoom.player = p), 0) WHERE p.id = :playerId")
    void updatePlayerScore(@Param("playerId") Long playerId);

}
