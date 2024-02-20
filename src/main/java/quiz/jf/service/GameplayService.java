package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.*;
import quiz.jf.repository.GameplayQuestionsRepository;
import quiz.jf.repository.GameplayRepository;

import java.util.Collections;
import java.util.List;

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

    public Gameplay createGameplay(Long themeId){

        QuizRoom quizRoom = quizRoomService.findById(themeId);
        Player player = quizRoom.getPlayer();
        List<Question> allQuestions = questionService.findByTheme(quizRoom.getTheme());

        Collections.shuffle(allQuestions);

        List<Question> questions = allQuestions.subList(0, Math.min(10, allQuestions.size()));

        Gameplay gameplay = new Gameplay();
        gameplay.setQuizRoom(quizRoom);
        gameplay.setPlayer(player.getNickName());

        for (Question question : questions){
            GameplayQuestions gameplayQuestions = new GameplayQuestions();
            gameplayQuestions.setGameplay(gameplay);
            gameplayQuestions.setQuestion(question);
            gameplay.getQuestionGameplays().add(gameplayQuestions);
        }
        return gameplayRepository.save(gameplay);
    }

    public Gameplay findById(Long id){
        return gameplayRepository.findById(id).get();
    }

}
