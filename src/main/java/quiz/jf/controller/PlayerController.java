package quiz.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quiz.jf.model.Player;
import quiz.jf.service.PlayerService;

import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/save")
    public Player save(@RequestBody Player player){
        return playerService.playerSave(player);
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<Player> findById(@PathVariable Long id){
        return playerService.findById(id);
    }

}

