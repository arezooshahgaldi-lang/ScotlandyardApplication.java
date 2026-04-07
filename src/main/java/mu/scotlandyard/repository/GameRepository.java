package mu.scotlandyard.repository;

import mu.scotlandyard.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Integer> {

}
