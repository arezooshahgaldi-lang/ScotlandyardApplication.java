package mu.scotlandyard.controller;

import mu.scotlandyard.entity.GamePlayer;
import mu.scotlandyard.service.GamePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamePlayers")
public class GamePlayerController {

    private final GamePlayerService gamePlayerService;
    public GamePlayerController(GamePlayerService gamePlayerService) {
        this.gamePlayerService = gamePlayerService;
    }

    @GetMapping
    public List<GamePlayer> getGamePlayers() {
        return gamePlayerService.getAllGamePlayer();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GamePlayer> getGamePlayerById(@PathVariable Integer id) {
        GamePlayer gamePlayer = gamePlayerService.getGamePlayerById(id);
        if (gamePlayer != null) {
            return ResponseEntity.ok(gamePlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<GamePlayer>createGamePlayer(@RequestBody GamePlayer gamePlayer) {
       GamePlayer created= gamePlayerService.createGamePlayer(gamePlayer);
       return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GamePlayer>UpdateGamePlayer(@PathVariable Integer id, @RequestBody GamePlayer gamePlayer) {
        GamePlayer updated= gamePlayerService.updateGamePlayer(id, gamePlayer);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GamePlayer>deleteGamePlayerById(@PathVariable Integer id) {
        gamePlayerService.deleteGamePlayerById(id);
        return ResponseEntity.noContent().build();
    }
}
