package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.jf.dto.PlayerDTO;
import quiz.jf.model.Player;
import quiz.jf.service.PlayerService;

import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/save")
    public PlayerDTO save(@RequestBody PlayerDTO playerDTO){
        return playerService.playerSave(playerDTO);
    }

    @GetMapping("/find-by-id/{id}")
    public PlayerDTO findById(@PathVariable Long id){
        return playerService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        playerService.playerDelete(id);
    }

}

