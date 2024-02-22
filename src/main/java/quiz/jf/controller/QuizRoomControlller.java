package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.jf.dto.QuizRoomDTO;
import quiz.jf.model.Player;
import quiz.jf.model.QuizRoom;
import quiz.jf.service.QuizRoomService;

@RestController
@RequestMapping("/room")
public class QuizRoomControlller {

    @Autowired
    private QuizRoomService quizRoomService;
    @PostMapping("/new-room")
    public QuizRoomDTO startQuizRoom(String theme, String nickName){
        return quizRoomService.startQuizRoom(theme, nickName);
    }

    @GetMapping("/find-by-id/{id}")
    public QuizRoomDTO findById(Long id){
        return quizRoomService.findById(id);
    }
}
