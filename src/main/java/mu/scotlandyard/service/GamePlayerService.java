package mu.scotlandyard.service;

import mu.scotlandyard.entity.GamePlayer;
import mu.scotlandyard.repository.GamePlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamePlayerService{

    private final GamePlayerRepository gamePlayerRepository;

    public GamePlayerService(GamePlayerRepository gamePlayerRepository) {
        this.gamePlayerRepository = gamePlayerRepository;
    }

    public List<GamePlayer> getAllGamePlayer() {
        return gamePlayerRepository.findAll();
    }


    public GamePlayer getGamePlayerById(Integer id) {
        return gamePlayerRepository.findById(id).orElse(null);
    }


    public List<GamePlayer> getGamePlayersByGameId(Integer gameId) {
        return gamePlayerRepository.findByGame_Id(gameId);
    }


    public List<GamePlayer> getGamePlayersByPlayerId(Integer playerId) {
        return gamePlayerRepository.findByPlayer_Id(playerId);
    }
    public boolean existsByGameIdAndPlayerId(Integer gameId, Integer playerId) {
        return gamePlayerRepository.existsByGameIdAndPlayerId(gameId, playerId);
    }
    public GamePlayer saveGamePlayer(GamePlayer gamePlayer) {
        return gamePlayerRepository.save(gamePlayer);
    }
    public GamePlayer createGamePlayer(GamePlayer gamePlayer) {
        return gamePlayerRepository.save(gamePlayer);
    }


    public GamePlayer updateGamePlayer(Integer id, GamePlayer updatedGamePlayer) {
        GamePlayer existingGamePlayer = gamePlayerRepository.findById(id).orElse(null);
        if (existingGamePlayer != null) {
            existingGamePlayer.setGame(updatedGamePlayer.getGame());
            existingGamePlayer.setPlayer(updatedGamePlayer.getPlayer());
            existingGamePlayer.setRole(updatedGamePlayer.getRole());

            return gamePlayerRepository.save(existingGamePlayer);
        }
        return null;
    }


    public void deleteGamePlayerById(Integer id) {
        gamePlayerRepository.deleteById(id);

    }
}
