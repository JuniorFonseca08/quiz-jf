package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public Gameplay createGameplay(@RequestParam Long roomId){
        return gameplayService.createGameplay(roomId);
    }

    @GetMapping("/{gameplayId}/questions")
    public List<Question> findAllQuestionsByGameplay(@PathVariable Long gameplayId){
        Gameplay gameplay = gameplayService.findById(gameplayId);
        return gameplayQuestionsService.findAllQuestionsByGameplay(gameplay);
    }


    @PostMapping("/questions/response")
    public ResponseEntity<?> findNextUnansweredQuestion(Gameplay gameplay, int playerAnswer) {
        GameplayQuestions nextQuestion = gameplayQuestionsService.findNextUnansweredQuestion(gameplay, playerAnswer);
        if (nextQuestion != null) {
            return ResponseEntity.ok("Resposta enviada com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todas as perguntas foram respondidas");
        }
    }

    @GetMapping("/{gameplayId}/find-nex-question")
    public ResponseEntity<List<QuestionAlternative>> findQuestionNoResponse(@PathVariable Long gameplayId) {
        Gameplay gameplay = gameplayService.findById(gameplayId);
        if (gameplay == null) {
            return ResponseEntity.notFound().build();
        }
        List<QuestionAlternative> nextQuestion = gameplayQuestionsService.findNextQuestion(gameplay);
        if (nextQuestion != null) {
            return ResponseEntity.ok(nextQuestion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
