package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.jf.dto.QuestionAlternativeDTO;
import quiz.jf.model.QuestionAlternative;
import quiz.jf.service.QuestionAlternativeService;

import java.util.List;

@RestController
@RequestMapping("/alternative")
public class QuestionAlternativeController {
    @Autowired
    private QuestionAlternativeService questionAlternativeService;

    @PostMapping("/save")
    public QuestionAlternativeDTO save(@RequestBody QuestionAlternativeDTO alternativeDTO){
        return questionAlternativeService.save(alternativeDTO);
    }

    @GetMapping("/find-all")
    public List<QuestionAlternativeDTO> findAll(){
        return questionAlternativeService.findAll();
    }

}
