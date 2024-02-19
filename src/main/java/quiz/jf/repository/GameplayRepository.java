package quiz.jf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.jf.model.Gameplay;

public interface GameplayRepository extends JpaRepository<Gameplay, Long> {
}
