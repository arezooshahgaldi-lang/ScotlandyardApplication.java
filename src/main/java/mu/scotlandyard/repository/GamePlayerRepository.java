package mu.scotlandyard.repository;

import mu.scotlandyard.entity.GamePlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamePlayerRepository extends JpaRepository<GamePlayer,Integer> {
    List<GamePlayer> findByGame_Id(Integer gameId);
    List<GamePlayer> findByPlayer_Id(Integer playerId);

    boolean existsByGameIdAndPlayerId(Integer gameId, Integer playerId);
}
