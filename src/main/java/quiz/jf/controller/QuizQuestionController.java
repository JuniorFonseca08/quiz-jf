package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.jf.model.QuizQuestion;
import quiz.jf.service.QuizQuestionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuizQuestionController {

    @Autowired
    private QuizQuestionService quizQuestionService;

    @GetMapping("find-all")
    public List<QuizQuestion> findAllQuestions() {
        return quizQuestionService.findAll();
    }

    @GetMapping("/{id}")
    public QuizQuestion findById(@PathVariable Long id){
        return quizQuestionService.findById(id);
    }

//    @GetMapping("find-by-theme/{theme}")
//    public List<QuizQuestion> findByTheme(String theme){
//        return quizQuestionService.findByTheme(theme);
//    }

    @PostMapping("/save")
    public QuizQuestion save(@RequestBody QuizQuestion question){
        return quizQuestionService.saveQuestion(question);
    }

    @PostMapping("/save-all")
    public List<QuizQuestion> saveAll(@RequestBody List<QuizQuestion> quizQuestionList){
        return quizQuestionService.saveAll(quizQuestionList);
    }

//    @GetMapping("/findByIdWithAlternatives/{id}")
//    public Optional<QuizQuestion> findByIdWithAlternatives(@PathVariable Long id){
//        return quizQuestionService.findByIdWithAlternatives(id);
//    }
}
