package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.jf.model.Player;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByEmail(String email);

    Player findByNickName(String nickName);

}
