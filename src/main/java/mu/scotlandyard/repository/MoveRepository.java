package mu.scotlandyard.repository;

import mu.scotlandyard.enoms.Transport;
import mu.scotlandyard.entity.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoveRepository extends JpaRepository<Move,Integer> {
    List<Move> findByTransport(Transport transport);
    List<Move>findByGameIdAndPlayerIdOrderByMovedAtDesc(Integer gameId,Integer playerId);
}
