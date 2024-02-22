package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.builder.QuizRoomMapper;
import quiz.jf.dto.PlayerDTO;
import quiz.jf.dto.QuizRoomDTO;
import quiz.jf.model.Player;
import quiz.jf.model.QuizRoom;
import quiz.jf.repository.PlayerRepository;
import quiz.jf.repository.QuizRoomRepository;

@Service
public class QuizRoomService {

    @Autowired
    private QuizRoomRepository quizRoomRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private QuizRoomMapper quizRoomMapper;

    public QuizRoomDTO startQuizRoom(String theme, String nickName){
        Player player = playerRepository.findByNickName(nickName);

        if (player == null) {
            throw new IllegalArgumentException("Player not found with nickName: " + nickName);
        }
        QuizRoom existingRoom = quizRoomRepository.findByThemeAndPlayer(theme, player);

        if (existingRoom != null){
            return quizRoomMapper.toDTO(existingRoom);
        } else {
            QuizRoom newRoom = new QuizRoom(theme, player);
            return quizRoomMapper.toDTO(quizRoomRepository.save(newRoom));
        }
    }

    public QuizRoomDTO findById(Long id){
        return quizRoomMapper.toDTO(quizRoomRepository.findById(id).get());
    }


}