package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quiz.jf.dto.*;
import quiz.jf.model.Gameplay;
import quiz.jf.model.GameplayQuestions;
import quiz.jf.model.Question;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.service.GameplayQuestionsService;
import quiz.jf.service.GameplayService;

import java.util.List;

@RestController
@RequestMapping("/gameplay")
public class GameplayController {

    @Autowired
    private GameplayService gameplayService;
    @Autowired
    private GameplayQuestionsService gameplayQuestionsService;

    @PostMapping("/create-gameplay")
    public GameplayDTO createGameplay(@RequestParam Long roomId){
        return gameplayService.createGameplay(roomId);
    }

    @GetMapping("/{gameplayId}/questions")
    public List<QuestionDTO> findAllQuestionsByGameplay(@PathVariable Long gameplayId){
        //Gameplay gameplay = gameplayService.findById(gameplayId);
        List<QuestionDTO> questions = gameplayService.findAllQuestionsByGameplay(gameplayId);
        return questions;
    }


    @PostMapping("/{gameplayId}/player-response")
    public ResponseEntity<?> playerResponse(@PathVariable Long gameplayId, @RequestParam int playerAnswer) {
        GameplayDTO gameplayDTO = gameplayService.findById(gameplayId);
        if (gameplayDTO == null) {
            return ResponseEntity.notFound().build();
        }
        GameplayQuestionsDTO nextQuestion = gameplayQuestionsService.playerResponse(gameplayDTO, playerAnswer);
        if (nextQuestion != null) {
            return ResponseEntity.ok("Resposta enviada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todas as perguntas foram respondidas");
        }
    }

    @GetMapping("/gameplay/{gameplayId}/next-question")
    public ResponseEntity<?> getNextQuestion(@PathVariable Long gameplayId) {
        SimpleQuestionDTO nextQuestions = gameplayQuestionsService.findNextQuestion(gameplayId);
        if (nextQuestions != null) {
            return ResponseEntity.ok(nextQuestions);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No unanswered questions found.");
        }
    }
}
