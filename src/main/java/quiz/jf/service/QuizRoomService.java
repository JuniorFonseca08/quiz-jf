package quiz.jf.service;

import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.Player;
import quiz.jf.model.QuizQuestion;
import quiz.jf.model.QuizRoom;
import quiz.jf.repository.PlayerRepository;
import quiz.jf.repository.QuizRoomRepository;

import java.util.ArrayList;

@Service
public class QuizRoomService {

    @Autowired
    private QuizRoomRepository quizRoomRepository;
    @Autowired
    private PlayerRepository playerRepository;

//    public QuizRoom startQuizRoom(String nickName, String theme){
//        QuizRoom existingRoom = quizRoomRepository.findByNickNameAndTheme(nickName, theme);
//
//        if (existingRoom != null){
//            return existingRoom;
//        } else {
//            QuizRoom newRoom = new QuizRoom(nickName, theme);
//            return quizRoomRepository.save(newRoom);
//        }
//    }

    public QuizRoom startQuizRoom(String theme, String nickName){
        Player player = playerRepository.findByNickName(nickName);

        if (player == null) {
            throw new IllegalArgumentException("Player not found with nickName: " + nickName);
        }
        QuizRoom existingRoom = quizRoomRepository.findByThemeAndPlayer(theme, player);

        if (existingRoom != null){
            return existingRoom;
        } else {
            QuizRoom newRoom = new QuizRoom(theme, player);
            return quizRoomRepository.save(newRoom);
        }
    }


}