package quiz.jf.service;

import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.Player;
import quiz.jf.model.QuizQuestion;
import quiz.jf.model.QuizRoom;
import quiz.jf.repository.QuizRoomRepository;

import java.util.ArrayList;

@Service
public class QuizRoomService {

    @Autowired
    private QuizRoomRepository quizRoomRepository;

    public QuizRoom startQuizRoom(Player player, String theme){
        String nickName = player.getNickName();
        QuizRoom existingRoom = quizRoomRepository.findByNickNameAndTheme(nickName, theme);

        if (existingRoom != null){
            return existingRoom;
        } else {

            QuizRoom newRoom = new QuizRoom(nickName, theme);
            return quizRoomRepository.save(newRoom);
        }
    }


}