package mu.scotlandyard.controller;

import mu.scotlandyard.dto.*;
import mu.scotlandyard.entity.Game;
import mu.scotlandyard.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameListResponse>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGamesForList());
    }
    @PostMapping
    public GameResponse createGame(@RequestBody CreateGameRequest request){
        return gameService.createGame(request);
    }
    @PutMapping
    public StartGameResponse startGame(@RequestBody StartGameRequest request){
        return gameService.startGame(request);
    }
    @PostMapping("/join")
    public ResponseEntity<JoinGameResponse> joinGame(@RequestBody JoinGameRequest request){
       JoinGameResponse response = gameService.joinGame(request);
       return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteGame(@PathVariable Integer id){
        gameService.deleteGame(id);
        return ResponseEntity.ok("Game deleted successfully");
    }
}
