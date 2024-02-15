package quiz.jf.model;

import jakarta.persistence.*;

@SequenceGenerator(name = "quiz_resultado_seq", allocationSize = 1)
@Entity
@Table(name = "quiz_resultado")
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_resultado_seq")
    private Long id;
    private Long score;
    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;

}
