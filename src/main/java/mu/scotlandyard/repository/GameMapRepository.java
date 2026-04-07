package mu.scotlandyard.repository;

import mu.scotlandyard.entity.GameMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameMapRepository extends JpaRepository<GameMap,Integer> {
    List<GameMap> findGameMapByGridWidth(Integer gridWidth);
    List<GameMap> findGameMapByGridHeight(Integer gridHeight);

    Optional<GameMap>findByName(String name);
}
