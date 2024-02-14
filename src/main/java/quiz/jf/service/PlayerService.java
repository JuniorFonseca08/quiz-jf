package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.model.Player;
import quiz.jf.repository.PlayerRepository;

import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player playerSave(Player player){
        // Verifica se já existe um jogador com o mesmo email
        Optional<Player> existingPlayerWithEmail = playerRepository.findByEmail(player.getEmail());
        if(existingPlayerWithEmail.isPresent()) {
            throw new IllegalArgumentException("Já existe um jogador com este email");
        }

        // Verifica se já existe um jogador com o mesmo nickname
        Player existingPlayerWithNickname = playerRepository.findByNickName(player.getNickName());
        if(existingPlayerWithNickname != null) {
            throw new IllegalArgumentException("Já existe um jogador com este nickname");
        }

        return playerRepository.save(player);
    }

    public void playerDelete(Player player){
        playerRepository.delete(player);
    }

    public Optional<Player> findById(Long id){
        return playerRepository.findById(id);
    }
}
