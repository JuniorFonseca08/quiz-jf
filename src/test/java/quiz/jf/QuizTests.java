package quiz.jf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import quiz.jf.model.Player;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.model.Question;
import quiz.jf.service.PlayerService;
import quiz.jf.service.QuestionService;
import quiz.jf.service.QuizRoomService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class QuizTests {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private QuizRoomService quizRoomService;
    @Autowired
    private QuestionService questionService;


    @Test
    void chamaSequenciaCrud(){
        //novoPlayer();
        //salvarQuestao();
        //criarSala();
    }


//    private void novoPlayer(){
//        Player playerSave = new Player("Theo", "Thais Moura", 30, "theomoura@gmail.com", "123Mudar");
//        playerService.playerSave(playerSave);
//        System.out.println("Retorno salvado: " + playerSave);
//
//        //return playerSave;
//    }

//    private void criarSala(){
//        Player player = new Player(1L, "Nuno");
//       // quizRoomService.startQuizRoom("Nuno","Jogos");
//    }


//    private void salvarQuestao(){
//        Question question = new Question();
//        question.setQuery("Qual é o jogo mais premiado da história?");
//        question.setTheme("Jogos");
//
//        List<QuestionAlternative> alternatives = new ArrayList<>();
//        alternatives.add(new QuestionAlternative("The Legend of Zelda: Breath of the Wild",false));
//        alternatives.add(new QuestionAlternative("The Witcher 3: Wild Hunt",true));
//        alternatives.add(new QuestionAlternative("Red Dead Redemption 2",false));
//        alternatives.add(new QuestionAlternative("God of War",false));
//
//        question.setAlternatives(alternatives);
//
//        questionService.saveQuestion(question);
//    }
}