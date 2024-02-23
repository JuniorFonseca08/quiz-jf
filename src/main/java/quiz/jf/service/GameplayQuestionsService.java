package quiz.jf.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quiz.jf.builder.GameplayQuestionsMapper;
import quiz.jf.builder.QuestionAlternativeMapper;
import quiz.jf.builder.QuestionMapper;
import quiz.jf.dto.*;
import quiz.jf.model.*;
import quiz.jf.repository.GameplayQuestionsRepository;
import quiz.jf.repository.GameplayRepository;
import quiz.jf.repository.PlayerRepository;
import quiz.jf.repository.QuestionAlternativeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameplayQuestionsService {

    @Autowired
    private GameplayQuestionsRepository gameplayQuestionsRepository;
    @Autowired
    private GameplayRepository gameplayRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GameplayQuestionsMapper gameplayQuestionsMapper;

    public GameplayQuestionsDTO save(GameplayQuestionsDTO gameplayQuestionsDTO){
        GameplayQuestions gameplayQuestions = gameplayQuestionsMapper.toEntity(gameplayQuestionsDTO);
        return gameplayQuestionsMapper.toDTO(gameplayQuestionsRepository.save(gameplayQuestions));
    }

    public GameplayQuestionsDTO findById(Long id) {
        GameplayQuestions gameplayQuestions = gameplayQuestionsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Gameplay question not found with ID: " + id));
        return gameplayQuestionsMapper.toDTO(gameplayQuestions);
    }

    public List<Question> findAllQuestionsByGameplay(Gameplay gameplay){
        return gameplayQuestionsRepository.findAllQuestionsByGameplay(gameplay);
    }

    public SimpleQuestionDTO findNextQuestion(Long gameplayId) {
        Gameplay gameplay = gameplayRepository.findById(gameplayId)
                .orElseThrow(() -> new IllegalArgumentException("Gameplay not found with ID: " + gameplayId));

        List<GameplayQuestions> unansweredQuestions = gameplayQuestionsRepository.findNextUnansweredQuestionByGameplay(gameplay);

        if (!unansweredQuestions.isEmpty()) {
            GameplayQuestions nextQuestion = unansweredQuestions.get(0);
            Question question = nextQuestion.getQuestion();

            SimpleQuestionDTO simpleQuestionDTO = new SimpleQuestionDTO();
            simpleQuestionDTO.setId(question.getId());
            simpleQuestionDTO.setQuery(question.getQuery());
            simpleQuestionDTO.setTheme(question.getTheme());

            List<AlternativeDTO> alternativeDTOs = question.getAlternatives().stream()
                    .map(alternative -> {
                        AlternativeDTO alternativeDTO = new AlternativeDTO();
                        alternativeDTO.setId(alternative.getId());
                        alternativeDTO.setAlternative(alternative.getAlternative());
                        return alternativeDTO;
                    })
                    .collect(Collectors.toList());

            simpleQuestionDTO.setAlternatives(alternativeDTOs);
            return simpleQuestionDTO;
        }
        return null;
    }

    @Transactional
    public GameplayQuestionsDTO playerResponse(GameplayDTO gameplayDTO, int playerAnswer) {

        Optional<Gameplay> optionalGameplay = gameplayRepository.findById(gameplayDTO.getId());

        if (optionalGameplay.isPresent()) {
            Gameplay gameplay = optionalGameplay.get();

            List<GameplayQuestions> unansweredQuestions = gameplayQuestionsRepository.findNextUnansweredQuestionByGameplay(gameplay);

            if (!unansweredQuestions.isEmpty()) {
                GameplayQuestions nextQuestion = unansweredQuestions.getFirst();

                boolean correctAnswer = nextQuestion.getQuestion().getAlternatives().stream()
                        .anyMatch(alternative -> alternative.getId() == playerAnswer && alternative.isCorrect());
                nextQuestion.setWasPlayed(true);

                if (correctAnswer) {
                    nextQuestion.setCorrectAnswer(true);
                    nextQuestion.setScore(100L);
                }
                GameplayQuestions savedQuestion = gameplayQuestionsRepository.save(nextQuestion);
                return gameplayQuestionsMapper.toDTO(savedQuestion);
            }
        }
        updateTotalScore(gameplayDTO.getId());
        updatePlayerScore(gameplayDTO.getId());
        return null;
    }

    @Transactional
    public void updateTotalScore(Long gameplayId) {
        gameplayRepository.calculateTotalScoreByGameplayId(gameplayId);
    }

    @Transactional
    public void updatePlayerScore(Long gameplayId){
        Gameplay gameplay = gameplayRepository.findById(gameplayId)
                .orElseThrow(() -> new IllegalArgumentException("Gameplay not found with ID: " + gameplayId));

        Long playerId = gameplay.getQuizRoom().getPlayer().getId();
        playerRepository.updatePlayerScore(playerId);
    }
}