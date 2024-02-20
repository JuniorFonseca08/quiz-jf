package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.Gameplay;
import quiz.jf.model.GameplayQuestions;
import quiz.jf.model.Question;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.repository.GameplayQuestionsRepository;

import java.util.List;
import java.util.Optional;

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

    public List<Question> findAllQuestionsByGameplay(Gameplay gameplay){
        return gameplayQuestionsRepository.findAllQuestionsByGameplay(gameplay);
    }

    public Question findNextUnansweredQuestion(Gameplay gameplay, String playerAnswer) {
        List<GameplayQuestions> questionGameplays = gameplay.getQuestionGameplays();

        Optional<GameplayQuestions> nextQuestion = questionGameplays.stream()
                .filter(question -> !question.getWasPlayed())
                .findFirst();

        if (nextQuestion.isPresent()) {
            GameplayQuestions nextQuestionObject = nextQuestion.get();
            Question question = nextQuestionObject.getQuestion();

            // Verifique se a resposta do jogador está correta
            boolean isCorrectAnswer = checkAnswer(question, playerAnswer);

            // Atualize o atributo correctAnswer se a resposta for correta
            if (isCorrectAnswer) {
                nextQuestionObject.setCorrectAnswer(true);
                // Salve a alteração no banco de dados
                save(nextQuestionObject);
            }

            return question;
        }
        return null;
    }

    // Método para verificar se a resposta do jogador está correta
    public boolean checkAnswer(Question question, String playerAnswer) {
        for (QuestionAlternative questionAlternative : question.getAlternatives()) {
            // Verifica se a alternativa é a correta e se o texto corresponde à resposta do jogador
            if (questionAlternative.isCorrect() && questionAlternative.getAlternative().equalsIgnoreCase(playerAnswer)) {
                return true; // Resposta correta encontrada
            }
        }
        return false;
    }




}
