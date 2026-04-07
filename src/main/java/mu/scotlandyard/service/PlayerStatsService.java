package mu.scotlandyard.service;


import mu.scotlandyard.entity.PlayerStats;
import mu.scotlandyard.repository.PlayerStatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerStatsService {
    private PlayerStatsRepository playerStatsRepository;

    public PlayerStatsService(PlayerStatsRepository playerStateRepository) {
        this.playerStatsRepository = playerStateRepository;
    }
    public List<PlayerStats> getAllPlayerStats() {
      return playerStatsRepository.findAll();
    }
    public PlayerStats getPlayerStatsByPlayerId(Integer playerId) {
        return playerStatsRepository.findById(playerId)
                .orElseThrow(()->new RuntimeException("playerStats not found"));
    }
    public PlayerStats getPlayerStatsByGamesPlayed(Integer gamesPlayed) {
        return playerStatsRepository.findById(gamesPlayed)
                .orElseThrow(()->new RuntimeException("playerStats not found"));
    }
    public PlayerStats getPlayerStatsByGamesWon(Integer gamesWon) {
        return playerStatsRepository.findById(gamesWon).orElseThrow(()->new RuntimeException("playerStats not found"));
    }

    public PlayerStats createPlayerStas(PlayerStats playerStats) {
        return playerStatsRepository.save(playerStats);
    }
}
