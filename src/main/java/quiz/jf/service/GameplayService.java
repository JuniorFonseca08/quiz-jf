package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.builder.GameplayMapper;
import quiz.jf.builder.QuestionMapper;
import quiz.jf.dto.GameplayDTO;
import quiz.jf.dto.QuestionDTO;
import quiz.jf.dto.QuizRoomDTO;
import quiz.jf.model.*;
import quiz.jf.repository.GameplayQuestionsRepository;
import quiz.jf.repository.GameplayRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameplayService {

    @Autowired
    private GameplayRepository gameplayRepository;
    @Autowired
    private GameplayQuestionsService gameplayQuestionsService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizRoomService quizRoomService;
    @Autowired
    private GameplayMapper gameplayMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public GameplayDTO createGameplay(Long themeId){

        QuizRoomDTO quizRoomDTO = quizRoomService.findById(themeId);
        QuizRoom quizRoom = new QuizRoom();
        quizRoom.setId(quizRoomDTO.getId());

        List<QuestionDTO> allQuestions = questionService.findByTheme(quizRoomDTO.getTheme());
        Collections.shuffle(allQuestions);

        List<QuestionDTO> selectedQuestions = allQuestions.subList(0, Math.min(10, allQuestions.size()));

        Gameplay gameplay = new Gameplay();
        gameplay.setQuizRoom(quizRoom);
        gameplay.setPlayer(quizRoomDTO.getPlayer().getNickName());

        for (QuestionDTO questionDTO : selectedQuestions){
            GameplayQuestions gameplayQuestions = new GameplayQuestions();
            gameplayQuestions.setGameplay(gameplay);

            Question question = new Question();
            question.setId(questionDTO.getId());

            gameplayQuestions.setQuestion(question);
            gameplay.getQuestionGameplays().add(gameplayQuestions);
        }
        return gameplayMapper.toDTO(gameplayRepository.save(gameplay));
    }

    public GameplayDTO findById(Long id){
        return gameplayMapper.toDTO(gameplayRepository.findById(id).get());
    }

    public List<QuestionDTO> findAllQuestionsByGameplay(Long gameplayId) {
        Gameplay gameplay = gameplayRepository.findById(gameplayId).orElse(null);
        if (gameplay != null) {
            return gameplay.getQuestionGameplays().stream()
                    .map(GameplayQuestions::getQuestion)
                    .map(questionMapper::toDTO) // Substitua "questionMapper" pelo seu mapper de QuestionDTO
                    .collect(Collectors.toList());
        } else {
            // Lida com o caso em que o gameplay não é encontrado
            return Collections.emptyList();
        }
    }

}
