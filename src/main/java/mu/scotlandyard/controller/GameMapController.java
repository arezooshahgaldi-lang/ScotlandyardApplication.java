package mu.scotlandyard.controller;

import mu.scotlandyard.entity.GameMap;
import mu.scotlandyard.service.GameMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gameMaps")
public class GameMapController {
    private final GameMapService gameMapService;
    public GameMapController(GameMapService gameMapService) {
        this.gameMapService = gameMapService;
    }
    @GetMapping
    public List<GameMap> getAllGameMaps() {
        return gameMapService.getAllGameMaps();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GameMap> getGameMapById(@PathVariable Integer id) {
        GameMap gameMap = gameMapService.getGameMapById(id);
        return(gameMap !=null)?ResponseEntity.ok(gameMap):ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameMap> update(@PathVariable Integer id,@RequestBody GameMap updateMap){
        GameMap result = gameMapService.updateGameMap(id,updateMap);
        return (result != null) ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public GameMap create(@RequestBody GameMap gameMap){
        return gameMapService.createGameMap(gameMap);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        gameMapService.deleteGameMapById(id);
        return ResponseEntity.noContent().build();

    }

}
