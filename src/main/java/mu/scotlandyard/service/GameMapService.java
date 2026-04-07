package mu.scotlandyard.service;

import mu.scotlandyard.entity.GameMap;
import mu.scotlandyard.repository.GameMapRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameMapService {

    private final GameMapRepository gameMapRepository;

    public GameMapService(GameMapRepository gameMapRepository) {
        this.gameMapRepository = gameMapRepository;
    }

  
    public List<GameMap> getAllGameMaps() {
        return gameMapRepository.findAll();
    }

   
    public GameMap getGameMapById(Integer id) {
        return gameMapRepository.findById(id).orElse(null);
    }

    public GameMap getGameMapByName(String name) {
        return gameMapRepository.findByName(name).orElse(null);
    }

 
    public GameMap createGameMap(GameMap gameMap) {
        return gameMapRepository.save(gameMap);
    }


    public GameMap updateGameMap(Integer id,GameMap updatedGameMap) {
        GameMap existingGameMap=gameMapRepository.findById(id).orElse(null);
        if (existingGameMap != null) {
            existingGameMap.setName(updatedGameMap.getName());
            existingGameMap.setGridHeight(updatedGameMap.getGridHeight());
            existingGameMap.setGridWidth(updatedGameMap.getGridWidth());
            existingGameMap.setDescription(updatedGameMap.getDescription());

            return gameMapRepository.save(existingGameMap);
        }
        return null;
    }

    
    public void deleteGameMapById(Integer id) {
        gameMapRepository.deleteById(id);

    }

   
    public List<GameMap> getGameMapsByGridWidth(Integer gridWidth) {
        return gameMapRepository.findGameMapByGridWidth(gridWidth);
    }

  
    public List<GameMap> getGameMapsByGridHeight(Integer gridHeight) {
        return gameMapRepository.findGameMapByGridHeight(gridHeight);
    }
}
