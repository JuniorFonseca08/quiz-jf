package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.service.QuestionAlternativeService;

import java.util.List;

@RestController
@RequestMapping("/alternative")
public class QuestionAlternativeController {
    @Autowired
    private QuestionAlternativeService questionAlternativeService;

//    @PostMapping("/save")
//    public QuestionAlternative save(@RequestBody QuestionAlternative alternative){
//        return questionAlternativeService.save(alternative);
//    }

    @GetMapping("/find-all")
    public List<QuestionAlternative> findAll(){
        return questionAlternativeService.findAll();
    }

}
