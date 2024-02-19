package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import quiz.jf.model.Gameplay;
import quiz.jf.repository.GameplayQuestionsRepository;
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

}
