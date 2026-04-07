package mu.scotlandyard.repository;

import mu.scotlandyard.dto.CatchAttemptProjection;
import mu.scotlandyard.entity.CatchAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatchAttemptRepository extends JpaRepository<CatchAttempt, Integer> {
    @Query("""
    SELECT new mu.scotlandyard.dto.CatchAttemptProjection(
        ca.gameId,
        gm.name,
        ca.successful
    )
    FROM CatchAttempt ca
    JOIN Game g ON ca.gameId = g.id
    JOIN g.map gm
    WHERE ca.gameId = :gameId
""")
    List<CatchAttemptProjection> findProjectionByGameId(@Param("gameId") Integer gameId);
    boolean existsByGameIdAndDetectiveIdAndThiefIdAndLocationId(
            Integer gameId,
            Integer detectiveId,
            Integer thiefId,
            Integer locationId
    );
}
