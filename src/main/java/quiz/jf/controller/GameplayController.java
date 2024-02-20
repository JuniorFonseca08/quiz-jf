package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.jf.model.Gameplay;
import quiz.jf.model.Question;
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

//    @GetMapping("/{gameplayId}/nextUnansweredQuestion")
//    public ResponseEntity<Question> getNextUnansweredQuestion(@PathVariable Long gameplayId) {
//        Gameplay gameplay = gameplayService.findById(gameplayId);
//        Question nextUnansweredQuestion = gameplayQuestionsService.findNextUnansweredQuestion(gameplay);
//
//        if (nextUnansweredQuestion != null) {
//            return ResponseEntity.ok(nextUnansweredQuestion);
//        } else {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
//    }

    @PostMapping("/check-answer")
    public Question checkAnswer(Gameplay question, String playerAnswer) {
        Question isCorrect = gameplayQuestionsService.findNextUnansweredQuestion(question, playerAnswer);
        return isCorrect;
    }
}
