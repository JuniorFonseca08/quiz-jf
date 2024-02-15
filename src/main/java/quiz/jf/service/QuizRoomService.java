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
        // Verifica se o jogador com o nickName fornecido existe
        Player player = playerRepository.findByNickName(nickName);

        if (player == null) {
            // Se o jogador não existir, você pode lidar com isso de acordo com a lógica do seu aplicativo
            throw new IllegalArgumentException("Player not found with nickName: " + nickName);
        }

        // Verifica se já existe uma sala com o nickName do jogador e o theme fornecidos
        QuizRoom existingRoom = quizRoomRepository.findByThemeAndPlayer(theme, player);

        if (existingRoom != null){
            // Se a sala já existir, retorne a sala existente
            return existingRoom;
        } else {
            // Se a sala não existir, crie uma nova sala associada ao jogador e a salve no banco de dados
            QuizRoom newRoom = new QuizRoom(theme, player);
            return quizRoomRepository.save(newRoom);
        }
    }


}