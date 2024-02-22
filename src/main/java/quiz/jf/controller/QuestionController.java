package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.jf.dto.QuestionDTO;
import quiz.jf.model.Question;
import quiz.jf.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/find-all")
    public List<QuestionDTO> findAllQuestions() {
        return questionService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public QuestionDTO findById(@PathVariable Long id){
        return questionService.findById(id);
    }

//    @GetMapping("find-by-theme/{theme}")
//    public List<Question> findByTheme(String theme){
//        return questionService.findByTheme(theme);
//    }

    @PostMapping("/save")
    public QuestionDTO save(@RequestBody QuestionDTO questionDTO){
        return questionService.saveQuestion(questionDTO);
    }

    @PostMapping("/save-all")
    public List<QuestionDTO> saveAll(@RequestBody List<QuestionDTO> questionDTOList){
        return questionService.saveAll(questionDTOList);
    }

}
