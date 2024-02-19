package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.jf.model.Question;
import quiz.jf.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("find-all")
    public List<Question> findAllQuestions() {
        return questionService.findAll();
    }

    @GetMapping("find-by-id/{id}")
    public Question findById(@PathVariable Long id){
        return questionService.findById(id);
    }

//    @GetMapping("find-by-theme/{theme}")
//    public List<Question> findByTheme(String theme){
//        return questionService.findByTheme(theme);
//    }

    @PostMapping("/save")
    public Question save(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }

    @PostMapping("/save-all")
    public List<Question> saveAll(@RequestBody List<Question> questionList){
        return questionService.saveAll(questionList);
    }

//    @GetMapping("/findByIdWithAlternatives/{id}")
//    public Optional<Question> findByIdWithAlternatives(@PathVariable Long id){
//        return questionService.findByIdWithAlternatives(id);
//    }
}
