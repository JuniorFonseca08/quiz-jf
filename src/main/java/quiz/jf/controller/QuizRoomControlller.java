package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quiz.jf.model.Player;
import quiz.jf.model.QuizRoom;
import quiz.jf.service.QuizRoomService;

@RestController
@RequestMapping("/room")
public class QuizRoomControlller {

    @Autowired
    private QuizRoomService quizRoomService;
    @PostMapping("/new-room")
    public QuizRoom startQuizRoom(String theme, String nickName){
        return quizRoomService.startQuizRoom(theme, nickName);
    }
}
