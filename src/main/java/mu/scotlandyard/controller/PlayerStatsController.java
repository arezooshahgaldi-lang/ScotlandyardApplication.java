package mu.scotlandyard.controller;

import mu.scotlandyard.entity.PlayerStats;
import mu.scotlandyard.service.PlayerStatsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playerStats")
public class PlayerStatsController {
    private final PlayerStatsService playerStasService;

    public PlayerStatsController(PlayerStatsService playerStasService) {
        this.playerStasService = playerStasService;
    }
    @GetMapping
    public List<PlayerStats> getPlayerStats() {
        return playerStasService.getAllPlayerStats();
    }
    @GetMapping("/{id}")
    public PlayerStats getPlayerStats(@PathVariable Integer id) {
        return playerStasService.getPlayerStatsByPlayerId(id);
    }
    @PostMapping
    public PlayerStats createPlayerStas(@RequestBody PlayerStats playerStats) {
        return playerStasService.createPlayerStas(playerStats);
    }
}
