package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.Gameplay;
import quiz.jf.model.GameplayQuestions;
import quiz.jf.model.Question;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.repository.GameplayQuestionsRepository;

import java.util.List;

@Service
public class GameplayQuestionsService {

    @Autowired
    private GameplayQuestionsRepository gameplayQuestionsRepository;

    public GameplayQuestions save(GameplayQuestions gameplayQuestions){
        return gameplayQuestionsRepository.save(gameplayQuestions);
    }

    public GameplayQuestions findById(Long id) {
        return gameplayQuestionsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Gameplay question not found with ID: " + id));
    }

    public void verifyPlayerResponses(Gameplay gameplay) {
        List<GameplayQuestions> gameplayQuestionsList = gameplay.getQuestionGameplays();

        for (GameplayQuestions gameplayQuestion : gameplayQuestionsList) {
            // Obtém a questão associada ao GameplayQuestions
            Question question = gameplayQuestion.getQuestion();

            // Obtém a alternativa correta da questão
            QuestionAlternative correctAlternative = question.getCorrectAlternative();

            // Obtém a alternativa selecionada pelo jogador
            QuestionAlternative selectedAlternative = gameplayQuestion.getSelectedAlternative();

            // Verifica se a alternativa selecionada é correta
            boolean isCorrect = selectedAlternative != null && selectedAlternative.isCorrect();

            // Atualiza as informações da questão no jogo
            gameplayQuestion.setWasPlayed(true);
            gameplayQuestion.setCorrectAnswer(isCorrect);
            gameplayQuestion.setScore(isCorrect ? 10L : 0L);

            // Salva a questão atualizada no banco de dados
            gameplayQuestionsRepository.save(gameplayQuestion);
        }
    }

}
