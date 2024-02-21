package quiz.jf.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quiz.jf.model.Gameplay;
import quiz.jf.model.GameplayQuestions;
import quiz.jf.model.Question;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.repository.GameplayQuestionsRepository;
import quiz.jf.repository.GameplayRepository;
import quiz.jf.repository.QuestionAlternativeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GameplayQuestionsService {

    @Autowired
    private GameplayQuestionsRepository gameplayQuestionsRepository;

    @Autowired
    private QuestionAlternativeRepository questionAlternativeRepository;

    @Autowired
    private GameplayRepository gameplayRepository;

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

    public List<QuestionAlternative> findNextQuestion(Gameplay gameplay) {
        List<GameplayQuestions> questionGameplays = gameplay.getQuestionGameplays();

        Optional<GameplayQuestions> nextQuestion = questionGameplays.stream()
                .filter(question -> !question.getWasPlayed())
                .findFirst();

        if (nextQuestion.isPresent()) {
            Question nextQuestionObject = nextQuestion.get().getQuestion();
            return nextQuestionObject.getAlternatives();
        }
        return null;
    }
    @Transactional
    public GameplayQuestions findNextUnansweredQuestion(Gameplay gameplay, int playerAnswer) {

        List<QuestionAlternative> nextQuestionAlternatives = findNextQuestion(gameplay);
        if (nextQuestionAlternatives != null && !nextQuestionAlternatives.isEmpty()) {
            // Encontra o ID da alternativa correta
            Long correctAlternativeId = nextQuestionAlternatives.stream()
                    .filter(QuestionAlternative::isCorrect)
                    .map(QuestionAlternative::getId)
                    .findFirst()
                    .orElse(null);

            // Encontra a instância de GameplayQuestions associada à Question
            GameplayQuestions nextQuestion = gameplay.getQuestionGameplays().stream()
                    .filter(question -> question.getQuestion().equals(nextQuestionAlternatives.get(0).getQuizQuestion()))
                    .findFirst()
                    .orElse(null);

            if (nextQuestion != null) {
                nextQuestion.setWasPlayed(true);

                if(correctAlternativeId != null && playerAnswer == correctAlternativeId){
                    nextQuestion.setCorrectAnswer(true);
                    nextQuestion.setScore(100L);
                }
                return gameplayQuestionsRepository.save(nextQuestion);
            }
        }
        updateTotalScore(gameplay.getId());
        return null;
    }

    @Transactional
    public void updateTotalScore(Long gameplayId) {
        gameplayRepository.calculateTotalScoreByGameplayId(gameplayId);
    }

}
