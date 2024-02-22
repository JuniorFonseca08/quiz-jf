package quiz.jf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.jf.builder.PlayerMapper;
import quiz.jf.dto.PlayerDTO;
import quiz.jf.model.Player;
import quiz.jf.repository.PlayerRepository;

import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerMapper playerMapper;

    public PlayerDTO playerSave(PlayerDTO playerDTO){
        Optional<Player> existingPlayerWithEmail = playerRepository.findByEmail(playerDTO.getEmail());
        if(existingPlayerWithEmail.isPresent()) {
            throw new IllegalArgumentException("Já existe um jogador com este email");
        }

        Player existingPlayerWithNickname = playerRepository.findByNickName(playerDTO.getNickName());
        if(existingPlayerWithNickname != null) {
            throw new IllegalArgumentException("Já existe um jogador com este nickname");
        }

        Player savedPlayer = playerRepository.save(playerMapper.toEntity(playerDTO));
        return playerMapper.toDTO(savedPlayer);
    }

    public void playerDelete(Long playerId){
        Player player = playerRepository.findById(playerId).get();
        playerRepository.delete(player);
    }

    public PlayerDTO findById(Long id){
        return playerMapper.toDTO(playerRepository.findById(id).get());
    }
}
