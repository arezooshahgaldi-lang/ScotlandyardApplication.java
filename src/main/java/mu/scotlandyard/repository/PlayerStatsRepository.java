package mu.scotlandyard.repository;

import mu.scotlandyard.entity.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatsRepository extends JpaRepository <PlayerStats,Integer>{
}
